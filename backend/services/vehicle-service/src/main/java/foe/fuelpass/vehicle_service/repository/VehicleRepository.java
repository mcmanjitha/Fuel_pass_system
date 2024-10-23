package foe.fuelpass.vehicle_service.repository;

import foe.fuelpass.vehicle_service.model.VehicleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleRegistration,String>
{

    VehicleRegistration findByChassisno(String chassiNo);
}
