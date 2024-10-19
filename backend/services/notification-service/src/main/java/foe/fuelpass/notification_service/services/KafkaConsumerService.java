package foe.fuelpass.notification_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final EmailService emailService;

    @KafkaListener(topics = "fuel-quota-updated", groupId = "notification-group")
    public void listenForQuotaUpdates(String message) {
        // Assume the message contains the user's email, subject, and body
        // This should be parsed according to your message structure
        String[] parts = message.split(";");
        String toEmail = parts[0];
        String subject = parts[1];
        String body = parts[2];

        emailService.sendEmail(toEmail, subject, body);
    }
}