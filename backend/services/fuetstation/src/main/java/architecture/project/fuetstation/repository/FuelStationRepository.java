package architecture.project.fuetstation.repository;

import architecture.project.fuetstation.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelStationRepository extends JpaRepository<FuelStation, String>
{

}
