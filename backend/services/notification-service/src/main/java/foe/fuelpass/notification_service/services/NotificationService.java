package foe.fuelpass.notification_service.services;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import foe.fuelpass.notification_service.dto.EmailRequest;
import foe.fuelpass.notification_service.dto.SmsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;

    @Value("${twilio.phone-number}")
    private String twilioPhoneNumber;

    public void sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());
        mailSender.send(message);
    }

    public void sendSms(SmsRequest smsRequest) {
        Message.creator(
                new PhoneNumber(smsRequest.getTo()),  // Recipient's phone number
                new PhoneNumber(twilioPhoneNumber),   // Twilio phone number
                smsRequest.getMessage()               // SMS body
        ).create();
    }
}
