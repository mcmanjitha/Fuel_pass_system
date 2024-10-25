package foe.fuelpass.admin_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin
{
    @Id
    private String adminid;
    private String adminname;
    private String password;
}
