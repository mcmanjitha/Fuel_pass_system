package architecture.project.fuetstation.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FuelStation
{
    @Id
    private String fuelStationID;
    private String fuelStationName;
    private String ownerName;
    private String province;
    private String district;
    private int contactNo;
}
