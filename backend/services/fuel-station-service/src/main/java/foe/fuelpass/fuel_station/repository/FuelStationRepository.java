package foe.fuelpass.fuel_station.repository;

import foe.fuelpass.fuel_station.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FuelStationRepository extends JpaRepository<FuelStation, String>
{

    FuelStation findByFuelstationid(String fuelstationid);
}
