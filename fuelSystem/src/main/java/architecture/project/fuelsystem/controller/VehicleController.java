package architecture.project.fuelsystem.controller;

import architecture.project.fuelsystem.model.VehicleRegistration;
import architecture.project.fuelsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController
{
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/validate")
    public String validate(@RequestParam String chassisno)
    {
        return vehicleService.validate(chassisno);
    }

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
    @GetMapping("/loginss")
    public String logins(@RequestBody VehicleRegistration vehicle)
    {
        return vehicleService.verifyss(vehicle);
    }

}
