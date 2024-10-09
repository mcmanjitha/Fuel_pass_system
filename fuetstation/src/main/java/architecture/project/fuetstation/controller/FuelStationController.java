package architecture.project.fuetstation.controller;

import architecture.project.fuetstation.model.FuelStation;
import architecture.project.fuetstation.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class FuelStationController
{
    @Autowired
    private FuelStationService fuelStationService ;

    @GetMapping("/validate")
    public String validate(@RequestParam String fuelStationID)
    {
        return fuelStationService.validate(fuelStationID);
    }

    @PostMapping("/register")
    public FuelStation register(@RequestBody FuelStation fuelStation)
    {
        return fuelStationService.register(fuelStation);
    }
}
