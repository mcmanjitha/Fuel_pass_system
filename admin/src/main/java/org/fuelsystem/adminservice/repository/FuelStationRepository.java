package org.fuelsystem.adminservice.repository;

import org.fuelsystem.adminservice.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelStationRepository extends JpaRepository<FuelStation, Long> {
    Optional<FuelStation> findByOwnerId(String ownerId);
}
