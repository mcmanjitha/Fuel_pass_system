package foe.fuelpass.admin_service.service;

import foe.fuelpass.admin_service.model.Admin;
import foe.fuelpass.admin_service.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService
{

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12) ;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;


    public String verify(Admin admin) {

        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getAdminid(), admin.getPassword()));

        if (authentication.isAuthenticated())
            return jwtService.generateToken(admin.getAdminid());

        return "fail";
    }

}



