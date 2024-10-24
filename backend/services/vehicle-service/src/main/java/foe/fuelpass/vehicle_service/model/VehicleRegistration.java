package foe.fuelpass.vehicle_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

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

    // Regex to enforce password rules: one special character, one uppercase, one digit
//    private static final String PASSWORD_PATTERN =
//            "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$";
//
//    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
//
//    public void setPassword(String password) {
//        Matcher matcher = pattern.matcher(password);
//        if (matcher.matches()) {
//            this.password = password;
//        } else {
//            throw new IllegalArgumentException("Password must contain at least one uppercase letter, one number, and one special character.");
//        }
//    }
}
