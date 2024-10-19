package foe.fuelpass.fuel_quota_service.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class FuelQuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vehicleId;
    private int quota; // Fuel quota in liters
    private int usedQuota;

    // Other fields such as quota reset date can be added as needed
}
