package foe.fuelpass.fuel_quota_service.repositories;

import foe.fuelpass.fuel_quota_service.entities.Pumper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PumperRepository extends JpaRepository<Pumper, Long> {
}