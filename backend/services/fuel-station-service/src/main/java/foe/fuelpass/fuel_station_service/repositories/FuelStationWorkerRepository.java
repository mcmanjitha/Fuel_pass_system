package foe.fuelpass.fuel_station_service.repositories;


import foe.fuelpass.fuel_station_service.entities.FuelStationWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelStationWorkerRepository extends JpaRepository<FuelStationWorker, Long> {
}