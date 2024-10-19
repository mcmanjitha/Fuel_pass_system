package foe.fuelpass.motor_traffic_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetails {
    private String licensePlate;
    private String ownerId;
    private boolean valid;
}