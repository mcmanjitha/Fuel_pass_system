package foe.fuelpass.fuel_quota_service.services;

import foe.fuelpass.fuel_quota_service.Dto.AddUserDto;
import foe.fuelpass.fuel_quota_service.Dto.FuelQuotaOutputDto;
import foe.fuelpass.fuel_quota_service.entities.FuelQuota;

import java.util.List;

public interface FuelQuotaService {
    FuelQuotaOutputDto findByVehicleId(Long vehicleId);
    void updateQuota(Long vehicleId, int usedFuel);
    void resetQuota();

    AddUserDto addUser(FuelQuota fuelQuota);

    List<FuelQuota> findAllQuotas();
}
