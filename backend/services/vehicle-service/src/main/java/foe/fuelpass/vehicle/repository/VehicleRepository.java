package foe.fuelpass.vehicle.repository;

import foe.fuelpass.vehicle.model.VehicleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleRegistration,String>
{

    VehicleRegistration findByChassisno(String chassiNo);
}
