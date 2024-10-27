package foe.fuelpass.admin_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FuelStation
{
    @Id
    private String fuelstationid;
    private String fuelstationname;
    private String password;
    private String ownername;
    private String ownerid;
    private String province;
    private String district;
    private String contactno;
}
