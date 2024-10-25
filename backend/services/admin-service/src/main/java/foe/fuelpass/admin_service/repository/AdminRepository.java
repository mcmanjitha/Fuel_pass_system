package foe.fuelpass.admin_service.repository;

import foe.fuelpass.admin_service.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, String>
{

    Admin findByAdminid(String adminid);
}
