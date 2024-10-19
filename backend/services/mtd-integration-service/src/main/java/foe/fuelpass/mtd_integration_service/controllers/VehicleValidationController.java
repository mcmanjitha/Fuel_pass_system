package foe.fuelpass.mtd_integration_service.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mtd")
public class VehicleValidationController {

    @GetMapping("/validate/{vehicleId}")
    public String validateVehicle(@PathVariable String vehicleId) {
        // Simulate a vehicle validation from the Motor Traffic Department
        // In a real-world scenario, you'd connect to their API or database
        // For demonstration, we assume validation is successful
        return "Vehicle with ID " + vehicleId + " is valid.";
    }
}