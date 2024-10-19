package foe.fuelpass.fuel_quota_service.repositories;

import foe.fuelpass.fuel_quota_service.entities.FuelQuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelQuotaRepository extends JpaRepository<FuelQuota, Long> {
}