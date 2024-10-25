package foe.fuelpass.fuel_quota_service.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PumperOutputDto {
    @Id
    private int Id;
    private String username;
    private String message;
}
