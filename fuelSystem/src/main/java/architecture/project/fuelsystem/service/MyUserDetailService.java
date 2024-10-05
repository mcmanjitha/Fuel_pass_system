package architecture.project.fuelsystem.service;

import architecture.project.fuelsystem.model.UserPrincipal;
import architecture.project.fuelsystem.model.VehicleRegistration;
import architecture.project.fuelsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService  implements UserDetailsService
{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public UserDetails loadUserByUsername(String chassiNo) throws UsernameNotFoundException
    {
        VehicleRegistration vehicle = vehicleRepository.findByChassisno(chassiNo);

        if(vehicle == null)
        {
            System.out.println("Vehicle Not found");
            throw new UsernameNotFoundException("Vehicle Not found");
        }

        return new UserPrincipal(vehicle);
    }
}
