package foe.fuelpass.vehicle_service.controllers;

import foe.fuelpass.vehicle_service.models.Vehicle;
import foe.fuelpass.vehicle_service.repositories.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerVehicle(@RequestBody Vehicle vehicle) {
        // Log to check if request is coming from API Gateway
        System.out.println("Request hit Vehicle Service for /register endpoint");

        // Check if the vehicle is already registered
        Vehicle existingVehicle = vehicleRepository.findByLicensePlate(vehicle.getLicensePlate());
        if (existingVehicle != null) {
            return ResponseEntity.badRequest().body("Vehicle with this license plate already exists.");
        }

        // Simulate QR code generation
        vehicle.setQrCode("generated-qr-code-" + vehicle.getLicensePlate());

        // Save the new vehicle
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        System.out.println("Request hit Vehicle Service for /{id} endpoint");

        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a simple mapping to check if the service is reachable
    @GetMapping("/check")
    public ResponseEntity<String> checkVehicleService() {
        System.out.println("Request hit Vehicle Service for /check endpoint");
        return ResponseEntity.ok("Vehicle Service is running and reached through API Gateway");
    }
}
