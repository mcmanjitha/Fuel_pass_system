package foe.fuelpass.vehicle.controller;

import foe.fuelpass.vehicle.model.VehicleRegistration;
import foe.fuelpass.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController
{
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehvalidate")
    public String validate(@RequestParam String chassisno, @RequestParam String nic)
    {
        return vehicleService.validate(chassisno, nic);
    }

    @PostMapping("/vehregister")
    public VehicleRegistration register(@RequestBody VehicleRegistration vehicle)
    {
        return vehicleService.register(vehicle);
    }

    @PostMapping("/vehlogin")
    public String login(@RequestBody VehicleRegistration vehicle)
    {
        return vehicleService.verify(vehicle);
    }


}
