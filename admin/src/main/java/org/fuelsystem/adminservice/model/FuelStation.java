package org.fuelsystem.adminservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuelStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fuelStationName;
    private String password;
    private String ownerName;
    private String contactNumber;
    private String district;
    private String province;
    private String ownerId;
    private String createdBy;
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date updatedDateTime;
}

