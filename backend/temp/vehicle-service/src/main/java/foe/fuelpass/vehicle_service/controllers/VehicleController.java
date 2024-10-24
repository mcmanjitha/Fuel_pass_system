package foe.fuelpass.vehicle_service.controllers;


import foe.fuelpass.vehicle_service.models.Vehicle;
import foe.fuelpass.vehicle_service.repositories.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Vehicle> registerVehicle(@RequestBody Vehicle vehicle) {
        // Here you would call the Motor Traffic Department Integration Service for validation.
        // After validation, you could generate the QR code and assign it to the vehicle.
        vehicle.setQrCode("generated-qr-code"); // Simulate QR code generation
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}