package foe.fuelpass.admin_service.controllers;

import foe.fuelpass.admin_service.model.Admin;
import foe.fuelpass.admin_service.model.FuelQuota;
import foe.fuelpass.admin_service.model.FuelStation;
import foe.fuelpass.admin_service.model.VehicleRegistration;
import foe.fuelpass.admin_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminServiceController
{
    @Autowired
    private AdminService adminService ;


    @PostMapping("/login")
    public String login(@RequestBody Admin admin)
    {
        return adminService.verify(admin);
    }

    @GetMapping("/all-vehicles")
    public List<VehicleRegistration> getAllVehicles() {
        return adminService.getAllVehicles();
    }

    @GetMapping("/all-stations")
    public List<FuelStation> getAllFuelStations() {
        return adminService.getAllFuelStations();
    }


}




