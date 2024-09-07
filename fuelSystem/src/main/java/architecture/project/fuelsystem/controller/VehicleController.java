package architecture.project.fuelsystem.controller;

import architecture.project.fuelsystem.model.VehicleRegistration;
import architecture.project.fuelsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController
{
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/register")
    public VehicleRegistration register(@RequestBody VehicleRegistration vehicle)
    {
        return vehicleService.register(vehicle);
    }

    @PostMapping("/login")
    public String login(@RequestBody VehicleRegistration vehicle)
    {
        return vehicleService.verify(vehicle);
    }

}
