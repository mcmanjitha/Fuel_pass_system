package foe.fuelpass.motor_traffic_service.controllers;

import foe.fuelpass.motor_traffic_service.models.VehicleDetails;
import foe.fuelpass.motor_traffic_service.services.VehicleValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/validate")
public class VehicleValidationController {

    private final VehicleValidationService validationService;

    public VehicleValidationController(VehicleValidationService validationService) {
        this.validationService = validationService;
    }

    @GetMapping("/vehicle")
    public ResponseEntity<VehicleDetails> validateVehicle(
            @RequestParam String licensePlate,
            @RequestParam String ownerId) {

        VehicleDetails validationResult = validationService.validateVehicle(licensePlate, ownerId);
        return ResponseEntity.ok(validationResult);
    }
}