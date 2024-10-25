package foe.fuelpass.fuel_station_service.repository;

import foe.fuelpass.fuel_station_service.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FuelStationRepository extends JpaRepository<FuelStation, String>
{

    FuelStation findByFuelstationid(String fuelstationid);
}
