package architecture.project.fuetstation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PetroleumDepartment
{
    @Id
    private String fuelStationID;
    private String fuelStationName;
    private String province;
    private String district;
    private int contactNo;
}
