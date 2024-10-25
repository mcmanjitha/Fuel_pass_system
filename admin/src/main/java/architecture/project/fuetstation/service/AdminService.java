package architecture.project.fuetstation.service;


import architecture.project.fuetstation.model.Admin;
import architecture.project.fuetstation.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService
{
    @Autowired
    private AdminRepository adminRepository;

    public String verify(Admin admin) {
        Optional<Admin> existingAdmin = adminRepository.findByAdminid(admin.getAdminid());

        if (existingAdmin.isPresent()) {
            // Check if the password matches
            if (existingAdmin.get().getPassword().equals(admin.getPassword())) {
                return "success password";
            } else {
                return "Invalid password";
            }
        }
        return "Failed";
    }
}

