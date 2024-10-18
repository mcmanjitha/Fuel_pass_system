package foe.fuelpass.motor_traffic_service.services;

import foe.fuelpass.motor_traffic_service.models.VehicleDetails;
import org.springframework.stereotype.Service;

@Service
public class VehicleValidationService {

    // Simulate checking against the Motor Traffic Department's database
    public VehicleDetails validateVehicle(String licensePlate, String ownerId) {
        // For demo purposes, assume every vehicle is valid.
        return new VehicleDetails(licensePlate, ownerId, true);
    }
}