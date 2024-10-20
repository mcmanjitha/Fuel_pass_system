package foe.fuelpass.vehicle.repository;

import foe.fuelpass.vehicle.model.DepartmentDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentDatabase,String>
{

    Optional<DepartmentDatabase> findByChassisnoAndNic(String chassisno, String nic);
}
