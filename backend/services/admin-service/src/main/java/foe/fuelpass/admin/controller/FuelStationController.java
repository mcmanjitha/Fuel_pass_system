package foe.fuelpass.admin.controller;

import foe.fuelpass.admin.model.Admin;
import foe.fuelpass.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FuelStationController
{
    @Autowired
    private AdminService adminService ;


    @PostMapping("/adminlogin")
    public String login(@RequestBody Admin admin)
    {
        return adminService.verify(admin);
    }


}

