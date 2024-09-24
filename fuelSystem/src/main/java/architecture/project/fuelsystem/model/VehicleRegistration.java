package architecture.project.fuelsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class VehicleRegistration
{
    @Id
    private String chassisno;
    private String fullname;
    private String nic;
    private String email;
    private int mobile;
    private String licenseplateno;
    private String type;
    private int registeredyear;

}
