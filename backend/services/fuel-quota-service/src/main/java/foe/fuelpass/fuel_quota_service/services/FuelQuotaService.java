package foe.fuelpass.fuel_quota_service.services;



import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelQuotaService {


    private final KafkaTemplate<String, String> kafkaTemplate;



    public void updateQuota(Long vehicleId, int usedFuel) {


        // Send a Kafka message for notification
        kafkaTemplate.send("fuel-quota-updated", "Fuel quota updated for vehicle ID: " + vehicleId);
    }

    public void resetQuota() {
        // Logic to reset quota (e.g., every week)
    }
}