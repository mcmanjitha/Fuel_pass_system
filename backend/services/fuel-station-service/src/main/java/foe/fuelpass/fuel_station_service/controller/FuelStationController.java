package foe.fuelpass.fuel_station_service.controller;

import foe.fuelpass.fuel_station_service.model.FuelStation;
import foe.fuelpass.fuel_station_service.model.LoginDTO;
import foe.fuelpass.fuel_station_service.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class FuelStationController {

    @Autowired
    private FuelStationService fuelStationService;

    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam String fuelstationid, @RequestParam String ownerid) {
        String validationResponse = fuelStationService.validate(fuelstationid, ownerid);
        if (validationResponse.equals("Valid")) {
            return ResponseEntity.ok(validationResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(validationResponse);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<FuelStation> register(@RequestBody FuelStation fuelStation) {
        FuelStation registeredStation = fuelStationService.register(fuelStation);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredStation);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginRequest) {
        String loginResponse = fuelStationService.verify(loginRequest);
        if (loginResponse.equals("Login successful")) {
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
    }

    @GetMapping("/all")
    public List<FuelStation> getAllFuelStations()
    {
        return fuelStationService.getAllFuelStations();
    }
}
