package foe.fuelpass.admin_service.service;

import foe.fuelpass.admin_service.model.Admin;
import foe.fuelpass.admin_service.model.FuelQuota;
import foe.fuelpass.admin_service.model.FuelStation;
import foe.fuelpass.admin_service.model.VehicleRegistration;
import foe.fuelpass.admin_service.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdminService
{

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12) ;

    @Autowired
    private RestTemplate restTemplate;

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

    public List<VehicleRegistration> getAllVehicles() {

        String url = "http://localhost:10002/vehicle/all";
        ResponseEntity<List<VehicleRegistration>> response = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<VehicleRegistration>>() {}
        );
        return response.getBody();
    }

    public List<FuelStation> getAllFuelStations() {

        String urlStation = "http://localhost:10003/station/all";
        ResponseEntity<List<FuelStation>> response = restTemplate.exchange(
                urlStation, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<FuelStation>>() {}
        );
        return response.getBody();
    }



}



