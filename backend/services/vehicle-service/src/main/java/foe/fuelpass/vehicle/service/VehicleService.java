package foe.fuelpass.vehicle.service;

import foe.fuelpass.vehicle.model.DepartmentDatabase;
import foe.fuelpass.vehicle.model.VehicleRegistration;
import foe.fuelpass.vehicle.repository.DepartmentRepository;
import foe.fuelpass.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService
{
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12) ;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    public String validate(String chassisno, String nic) {
        Optional<DepartmentDatabase> availableVehicle = departmentRepository.findByChassisnoAndNic(chassisno, nic);
        if (availableVehicle.isPresent()) {
            return "Validated";
        } else {
            return "Not Validated";
        }
    }

    public VehicleRegistration register(VehicleRegistration vehicle) {
        // Validate the vehicle before proceeding with registration
        String validationStatus = validate(vehicle.getChassisno(), vehicle.getNic());
        if (!validationStatus.equals("Validated")) {
            throw new IllegalArgumentException("Vehicle with chassis number " + vehicle.getChassisno() + " is not validated.");
        }

        // Check if the vehicle with the given chassis number already exists
        Optional<VehicleRegistration> existingVehicle = vehicleRepository.findById(vehicle.getChassisno());
        if (existingVehicle.isPresent()) {
            // Handle the case where the chassis number already exists
            throw new IllegalArgumentException("Vehicle with chassis number " + vehicle.getChassisno() + " already exists.");
        }
        vehicle.setPassword(encoder.encode(vehicle.getPassword()));
        return vehicleRepository.save(vehicle);
    }

    public String verify(VehicleRegistration vehicle)
    {
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                vehicle.getChassisno(), vehicle.getPassword());
//        Authentication authentication = authManager.authenticate(authenticationToken);

        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(vehicle.getChassisno(),vehicle.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(vehicle.getChassisno());

        return "fail";
    }

}
