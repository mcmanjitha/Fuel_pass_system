package foe.fuelpass.fuel_station_service.repository;

import foe.fuelpass.fuel_station_service.model.PetroleumDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetroleumDepartmentRepository extends JpaRepository<PetroleumDepartment,String>
{

    Optional<PetroleumDepartment> findByFuelstationidAndOwnerid(String fuelstationid, String ownerid);

}
