package foe.fuelpass.fuel_quota_service.services;


import foe.fuelpass.fuel_quota_service.entities.FuelQuota;
import foe.fuelpass.fuel_quota_service.repositories.FuelQuotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelQuotaService {

    private final FuelQuotaRepository quotaRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public List<FuelQuota> findAll() {
        return quotaRepository.findAll();
    }

    public FuelQuota findByVehicleId(Long vehicleId) {
        return quotaRepository.findById(vehicleId).orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
    }

    public FuelQuota save(FuelQuota fuelQuota) {
        return quotaRepository.save(fuelQuota);
    }

    public void updateQuota(Long vehicleId, int usedFuel) {
        FuelQuota fuelQuota = findByVehicleId(vehicleId);
        fuelQuota.setUsedQuota(fuelQuota.getUsedQuota() + usedFuel);
        quotaRepository.save(fuelQuota);

        // Send a Kafka message for notification
        kafkaTemplate.send("fuel-quota-updated", "Fuel quota updated for vehicle ID: " + vehicleId);
    }

    public void resetQuota() {
        // Logic to reset quota (e.g., every week)
    }
}