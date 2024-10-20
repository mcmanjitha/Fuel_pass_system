package architecture.project.fuetstation.repository;

import architecture.project.fuetstation.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,String>
{

    Optional<Admin> findByAdminid(String adminid);
}
