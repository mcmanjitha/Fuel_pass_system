package org.fuelsystem.adminservice.model.DTO;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuelStationDTO {
    private String id;
    private String fuelStationName;
//    private String password;
    private String ownerName;
    private String contactNumber;
    private String district;
    private String province;
    private String ownerId;
    private String createdBy;
    private String updatedBy;
    private Date createdDateTime;
    private Date updatedDateTime;
}
