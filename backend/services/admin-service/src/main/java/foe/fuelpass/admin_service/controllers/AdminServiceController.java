package foe.fuelpass.admin_service.controllers;

import foe.fuelpass.admin_service.model.Admin;
import foe.fuelpass.admin_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}

