package foe.fuelpass.admin_service.model;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class FuelQuota {

    private Long id;

    private Long vehicleId;
    private int quota; // Fuel quota in liters
    private int availableQuota;

    // Other fields such as quota reset date can be added as needed
}
