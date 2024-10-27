package foe.fuelpass.vehicle_service.controller;

import foe.fuelpass.vehicle_service.Dtos.QRdataDto;
import foe.fuelpass.vehicle_service.model.LoginDTO;
import foe.fuelpass.vehicle_service.model.VehicleRegistration;
import foe.fuelpass.vehicle_service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
//    @GetMapping("/test")
//    public ResponseEntity<String> register() {
//        System.out.println("Vehicle registration called: " );
//        return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle registered successfully!");
//    }

    @Autowired
    private VehicleService vehicleService;





//    @GetMapping("/validate")
//    public ResponseEntity<String> validate(@RequestParam String chassisno, @RequestParam String nic) {
//        String result = vehicleService.validate(chassisno, nic);
//        if (result.equals("Validated")) {
//            return ResponseEntity.ok(result); // HTTP 200
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); // HTTP 400
//        }
//    }

    @PostMapping("/register")
    public ResponseEntity<QRdataDto> register(@RequestBody VehicleRegistration vehicle) {
        try {
            QRdataDto qRdataDto = vehicleService.register(vehicle);
            return ResponseEntity.status(HttpStatus.CREATED).body(qRdataDto); // HTTP 201
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // HTTP 400
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginRequest) {
//        String chassisno = loginRequest.getChassisno();
//        String password = loginRequest.getPassword();
        String token = vehicleService.verify(loginRequest);
        if (!token.equals("fail")) {
            return ResponseEntity.ok(token); // HTTP 200
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"); // HTTP 401
        }
    }

    @GetMapping("/all")
    public List<VehicleRegistration> getAllVehicles()
    {
        return vehicleService.getAllVehicles();
    }

}
