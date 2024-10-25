package foe.fuelpass.fuel_station_service.controller;

import foe.fuelpass.fuel_station_service.model.FuelStation;
import foe.fuelpass.fuel_station_service.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class FuelStationController
{
    @Autowired
    private FuelStationService fuelStationService ;

    @GetMapping("/validate")
    public String validate(@RequestParam String fuelstationid,@RequestParam String ownerid)
    {
        return fuelStationService.validate(fuelstationid,ownerid);
    }

    @PostMapping("/register")
    public FuelStation register(@RequestBody FuelStation fuelStation)
    {
        return fuelStationService.register(fuelStation);
    }

    @PostMapping("/login")
    public String login(@RequestBody FuelStation fuelStation)
    {
        return fuelStationService.verify(fuelStation);
    }


}

