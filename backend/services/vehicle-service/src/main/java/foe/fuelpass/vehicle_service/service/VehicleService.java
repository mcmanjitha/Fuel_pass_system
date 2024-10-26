package foe.fuelpass.vehicle_service.service;

import foe.fuelpass.vehicle_service.Dtos.QRdataDto;
import foe.fuelpass.vehicle_service.model.DepartmentDatabase;
import foe.fuelpass.vehicle_service.model.LoginDTO;
import foe.fuelpass.vehicle_service.model.VehicleRegistration;
import foe.fuelpass.vehicle_service.repository.DepartmentRepository;
import foe.fuelpass.vehicle_service.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

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
        return availableVehicle.isPresent() ? "Validated" : "Not Validated";
    }

    public QRdataDto register(VehicleRegistration vehicle) {
        String validationStatus = validate(vehicle.getChassisno(), vehicle.getNic());
        if (!validationStatus.equals("Validated")) {
            throw new IllegalArgumentException("Vehicle with chassis number " + vehicle.getChassisno() + " is not validated.");
        }

        Optional<VehicleRegistration> existingVehicle = vehicleRepository.findById(vehicle.getChassisno());
        if (existingVehicle.isPresent()) {
            throw new IllegalArgumentException("Vehicle with chassis number " + vehicle.getChassisno() + " already exists.");
        }

        vehicle.setPassword(encoder.encode(vehicle.getPassword()));
        vehicle.setRegistrationDateTime(LocalDateTime.now()); // Set the current timestamp
        vehicleRepository.save(vehicle);
        QRdataDto qRdataDto = new QRdataDto();
        qRdataDto.setChassisno(vehicle.getChassisno());
        qRdataDto.setRegistrationDateTime(vehicle.getRegistrationDateTime());
        return qRdataDto;
    }

    public String verify(LoginDTO loginRequest) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getChassisno(), loginRequest.getPassword())
        );

        return authentication.isAuthenticated() ? jwtService.generateToken(loginRequest.getChassisno()) : "fail";
    }

    public List<VehicleRegistration> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}
