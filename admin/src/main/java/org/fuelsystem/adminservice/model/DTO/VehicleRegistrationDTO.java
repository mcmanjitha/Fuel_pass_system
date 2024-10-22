package org.fuelsystem.adminservice.model.DTO;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRegistrationDTO {
    private String chassisNumber;
    private String ownerId;
    private String ownerName;
    private String indentificationNumber;
    private String email;
    private String phone;
    private String vehicleNumber;
    private String vehicleType;
    private int registrationYear;
//    private String password;
    private String createdBy;
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date updatedDateTime;
}
