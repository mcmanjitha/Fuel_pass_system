package foe.fuelpass.vehicle_service.Dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QRdataDto {
    private String chassisno;
    private LocalDateTime registrationDateTime;

}
