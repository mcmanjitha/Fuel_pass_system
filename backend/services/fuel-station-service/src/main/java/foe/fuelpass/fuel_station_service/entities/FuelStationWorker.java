package foe.fuelpass.fuel_station_service.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class FuelStationWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role; // e.g. fuel attendant, cashier

    @ManyToOne
    @JoinColumn(name = "station_id")
    private FuelStation fuelStation;

}