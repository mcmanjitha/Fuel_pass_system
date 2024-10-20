package foe.fuelpass.fuel_station.controller;

import foe.fuelpass.fuel_station.model.FuelStation;
import foe.fuelpass.fuel_station.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FuelStationController
{
    @Autowired
    private FuelStationService fuelStationService ;

    @GetMapping("/statvalidate")
    public String validate(@RequestParam String fuelstationid,@RequestParam String ownerid)
    {
        return fuelStationService.validate(fuelstationid,ownerid);
    }

    @PostMapping("/statregister")
    public FuelStation register(@RequestBody FuelStation fuelStation)
    {
        return fuelStationService.register(fuelStation);
    }

    @PostMapping("/statlogin")
    public String login(@RequestBody FuelStation fuelStation)
    {
        return fuelStationService.verify(fuelStation);
    }


}

