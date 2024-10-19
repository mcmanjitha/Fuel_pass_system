package foe.fuelpass.fuel_quota_service.controllers;



import com.fuelpass.fuelquotaservice.entities.FuelQuota;
import com.fuelpass.fuelquotaservice.services.FuelQuotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fuel-quota")
@RequiredArgsConstructor
public class FuelQuotaController {

    private final FuelQuotaService quotaService;

    @GetMapping("/{vehicleId}")
    public ResponseEntity<FuelQuota> getQuota(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(quotaService.findByVehicleId(vehicleId));
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateQuota(@RequestParam Long vehicleId, @RequestParam int usedFuel) {
        quotaService.updateQuota(vehicleId, usedFuel);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reset")
    public ResponseEntity<Void> resetQuota() {
        quotaService.resetQuota();
        return ResponseEntity.noContent().build();
    }
}
