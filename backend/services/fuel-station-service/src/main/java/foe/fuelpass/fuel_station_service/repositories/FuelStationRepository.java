package foe.fuelpass.fuel_station_service.repositories;


import foe.fuelpass.fuel_station_service.entities.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelStationRepository extends JpaRepository<FuelStation, Long> {
}