package foe.fuelpass.fuel_quota_service.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class FuelQuota {
    @Id
    private Long id;

    private Long vehicleId;
    private int quota; // Fuel quota in liters
    private int availableQuota;

    // Other fields such as quota reset date can be added as needed
}
