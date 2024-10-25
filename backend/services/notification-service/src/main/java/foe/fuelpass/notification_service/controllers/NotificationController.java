package foe.fuelpass.notification_service.controllers;

import foe.fuelpass.notification_service.dto.EmailRequest;
import foe.fuelpass.notification_service.dto.SmsRequest;
import foe.fuelpass.notification_service.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        notificationService.sendEmail(emailRequest);
        return ResponseEntity.ok("Email sent successfully.");
    }

    @PostMapping("/sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest smsRequest) {
        notificationService.sendSms(smsRequest);
        return ResponseEntity.ok("SMS sent successfully.");
    }
}
