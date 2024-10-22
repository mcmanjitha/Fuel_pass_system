package org.fuelsystem.adminservice.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRegistrationCreateDTO {
    private String chassisNumber;
    private String ownerId;
    private String ownerName;
    private String indentificationNumber;
    private String email;
    private String phone;
    private String vehicleNumber;
    private String vehicleType;
    private int registrationYear;
    private String password;
    private String createdBy;
}
