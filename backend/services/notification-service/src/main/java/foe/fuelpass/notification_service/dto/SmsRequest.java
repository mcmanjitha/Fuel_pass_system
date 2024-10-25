package foe.fuelpass.notification_service.dto;

import lombok.Data;

@Data
public class SmsRequest {
    private String to;
    private String message;
}
