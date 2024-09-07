package architecture.project.fuelsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class VehicleRegistration
{
    @Id
    private String chasisNo;
    private String fullName;
    private String nic;
    private String email;
    private int mobile;
    private String licensePlateNo;
    private String type;
    private int registeredYear;

}
