package architecture.project.fuelsystem.repository;

import architecture.project.fuelsystem.model.VehicleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleRegistration,String>
{

    VehicleRegistration findByChassisno(String chassiNo);
}
