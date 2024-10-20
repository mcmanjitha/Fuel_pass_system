package foe.fuelpass.vehicle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DepartmentDatabase
{
    @Id
    private String chassisno;
    private String nic;
    private String brand;
    private String model;
    private String registeredyear;

}
