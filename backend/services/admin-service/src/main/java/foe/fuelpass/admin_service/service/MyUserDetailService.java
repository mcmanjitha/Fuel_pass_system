package foe.fuelpass.admin_service.service;

import foe.fuelpass.admin_service.model.Admin;
import foe.fuelpass.admin_service.model.UserPrincipal;
import foe.fuelpass.admin_service.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService  implements UserDetailsService
{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String adminid) throws UsernameNotFoundException
    {
        Admin admin = adminRepository.findByAdminid(adminid);

        if(admin == null)
        {
            System.out.println("Admin Not found");
            throw new UsernameNotFoundException("Admin Not found");
        }

        return new UserPrincipal(admin);
    }
}
