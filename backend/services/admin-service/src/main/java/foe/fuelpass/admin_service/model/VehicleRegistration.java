package foe.fuelpass.admin_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class VehicleRegistration {
    @Id
    private String chassisno;
    private String fullname;
    private String nic;
    private String email;
    private int mobile;
    private String licenseplateno;
    private String type;
    private int registeredyear;
    private String password;
    private LocalDateTime registrationDateTime;

}
