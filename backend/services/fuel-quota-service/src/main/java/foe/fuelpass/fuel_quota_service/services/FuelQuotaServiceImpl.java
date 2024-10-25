package foe.fuelpass.fuel_quota_service.services;


import foe.fuelpass.fuel_quota_service.Dto.AddUserDto;
import foe.fuelpass.fuel_quota_service.Dto.FuelQuotaOutputDto;
import foe.fuelpass.fuel_quota_service.entities.FuelQuota;
import foe.fuelpass.fuel_quota_service.repositories.FuelQuotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelQuotaServiceImpl implements FuelQuotaService {

    private final FuelQuotaRepository quotaRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public List<FuelQuota> findAll() {
        return quotaRepository.findAll();
    }

    public FuelQuotaOutputDto findByVehicleId(Long vehicleId) {
        FuelQuota fuelQuota = quotaRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
        // Convert to DTO
        return new FuelQuotaOutputDto(fuelQuota.getAvailableQuota());
    }

    public FuelQuota save(FuelQuota fuelQuota) {
        return quotaRepository.save(fuelQuota);
    }

    public void updateQuota(Long vehicleId, int usedFuel) {
        FuelQuota fuelQuota = quotaRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
        fuelQuota.setAvailableQuota(fuelQuota.getAvailableQuota() - usedFuel);
        quotaRepository.save(fuelQuota);


        // Send a Kafka message for notification
        kafkaTemplate.send("fuel-quota-updated", "Fuel quota updated for vehicle ID: " + vehicleId);
    }

    public void resetQuota() {
        List<FuelQuota> fuelQuotas = quotaRepository.findAll();
        for (FuelQuota fuelQuota : fuelQuotas) {
            fuelQuota.setAvailableQuota(fuelQuota.getQuota()); // Reset availableQuota to the quota value
        }
        quotaRepository.saveAll(fuelQuotas);
    }

    @Override
    public AddUserDto addUser(FuelQuota fuelQuota) {
        FuelQuota savedQuota = quotaRepository.save(fuelQuota);
        return new AddUserDto(savedQuota.getVehicleId(), savedQuota.getQuota());
    }

    @Override
    public List<FuelQuota> findAllQuotas() {
        return quotaRepository.findAll(); // Fetch all quotas from the repository
    }

}