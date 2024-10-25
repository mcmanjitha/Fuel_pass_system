package foe.fuelpass.fuel_station_service.service;

import foe.fuelpass.fuel_station_service.model.FuelStation;
import foe.fuelpass.fuel_station_service.model.LoginDTO;
import foe.fuelpass.fuel_station_service.model.PetroleumDepartment;
import foe.fuelpass.fuel_station_service.repository.FuelStationRepository;
import foe.fuelpass.fuel_station_service.repository.PetroleumDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuelStationService
{

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12) ;

    @Autowired
    private FuelStationRepository fuelStationRepository;

    @Autowired
    private PetroleumDepartmentRepository petroleumDepartmentRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    public String validate(String fuelstationid, String ownerid)
    {
        Optional<PetroleumDepartment> availableStation = petroleumDepartmentRepository.findByFuelstationidAndOwnerid(fuelstationid, ownerid);
        if (availableStation.isPresent()) {
            return "Validated";
        } else {
            return "Not Validated";
        }
    }

    public FuelStation register(FuelStation fuelStation)
    {
        // Validate the vehicle before proceeding with registration
        String validationStatus = validate(fuelStation.getFuelstationid(),fuelStation.getOwnerid());
        if (!validationStatus.equals("Validated")) {
            throw new IllegalArgumentException("Fuel station with fuel station ID number " + fuelStation.getFuelstationid() + " is not validated.");
        }

        // Check if the vehicle with the given chassis number already exists
        Optional<FuelStation> existingVehicle = fuelStationRepository.findById(fuelStation.getFuelstationid());
        if (existingVehicle.isPresent()) {
            // Handle the case where the chassis number already exists
            throw new IllegalArgumentException("Fuel station with fuel station ID number " + fuelStation.getFuelstationid() + " already exists.");
        }
        fuelStation.setPassword(encoder.encode(fuelStation.getPassword()));
        return fuelStationRepository.save(fuelStation);
    }

//    public String verify(FuelStation fuelStation) {
//
//        Authentication authentication =
//                authManager.authenticate(new UsernamePasswordAuthenticationToken(fuelStation.getFuelstationid(), fuelStation.getPassword()));
//
//        if (authentication.isAuthenticated())
//            return jwtService.generateToken(fuelStation.getFuelstationid());
//
//        return "fail";
//    }

    public String verify(LoginDTO loginRequest) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getFuelstationid(), loginRequest.getPassword())
        );

        return authentication.isAuthenticated() ? jwtService.generateToken(loginRequest.getFuelstationid()) : "fail";
    }

}



