package foe.fuelpass.fuel_station_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PetroleumDepartment
{
    @Id
    private String fuelstationid;
    private String ownerid;
    private String fuelstationname;
    private String province;
    private String district;
    private String contactno;
}
