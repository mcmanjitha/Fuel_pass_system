package foe.fuelpass.vehicle_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data // Lombok will generate getter, setter, equals, hashcode, and toString methods
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private String ownerId;

    @Column(nullable = false)
    private String qrCode;  // QR code generated for the vehicle
}