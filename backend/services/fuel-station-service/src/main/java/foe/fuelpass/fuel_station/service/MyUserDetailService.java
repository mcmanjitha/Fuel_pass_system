package foe.fuelpass.fuel_station.service;

import foe.fuelpass.fuel_station.model.FuelStation;
import foe.fuelpass.fuel_station.model.UserPrincipal;
import foe.fuelpass.fuel_station.repository.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService  implements UserDetailsService
{
    @Autowired
    private FuelStationRepository fuelStationRepository;

    @Override
    public UserDetails loadUserByUsername(String fuelstationid) throws UsernameNotFoundException
    {
        FuelStation fuelStation = fuelStationRepository.findByFuelstationid(fuelstationid);

        if(fuelStation == null)
        {
            System.out.println("Vehicle Not found");
            throw new UsernameNotFoundException("Vehicle Not found");
        }

        return new UserPrincipal(fuelStation);
    }
}
