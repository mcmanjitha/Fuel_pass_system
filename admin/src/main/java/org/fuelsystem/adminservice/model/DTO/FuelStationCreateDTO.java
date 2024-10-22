package org.fuelsystem.adminservice.model.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuelStationCreateDTO {
    private String fuelStationName;
    private String password;
    private String ownerName;
    private String contactNumber;
    private String district;
    private String province;
    private String ownerId;
    private String createdBy;
}
