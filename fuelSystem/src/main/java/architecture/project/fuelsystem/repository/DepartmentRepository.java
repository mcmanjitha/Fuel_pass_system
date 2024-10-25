package architecture.project.fuelsystem.repository;

import architecture.project.fuelsystem.model.DepartmentDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentDatabase,String>
{

}
