package foe.fuelpass.fuel_quota_service.controllers;


import foe.fuelpass.fuel_quota_service.entities.FuelQuota;
import foe.fuelpass.fuel_quota_service.services.FuelQuotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quota")
@RequiredArgsConstructor
public class FuelQuotaController {

    private final FuelQuotaService quotaService;

    @GetMapping("/test")
    public ResponseEntity<String> getQ() {
        System.out.println("Reached");

        // Return a simple text response
        return ResponseEntity.ok("Fuel Quota Service reached via fuel-station-service ");
    }


}
