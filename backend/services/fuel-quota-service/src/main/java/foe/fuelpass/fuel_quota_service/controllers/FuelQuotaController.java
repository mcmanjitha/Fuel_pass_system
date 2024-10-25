package foe.fuelpass.fuel_quota_service.controllers;
//import com.fuelpass.fuelquotaservice.entities.FuelQuota;
//import com.fuelpass.fuelquotaservice.services.FuelQuotaService;
import foe.fuelpass.fuel_quota_service.Dto.AddUserDto;
import foe.fuelpass.fuel_quota_service.Dto.FuelQuotaOutputDto;
import foe.fuelpass.fuel_quota_service.entities.FuelQuota;
import foe.fuelpass.fuel_quota_service.services.FuelQuotaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuel-quota")
@RequiredArgsConstructor
public class FuelQuotaController {

    private final FuelQuotaServiceImpl quotaService;

    @GetMapping("/{vehicleId}")
    public ResponseEntity<FuelQuotaOutputDto> getQuota(@PathVariable Long vehicleId) {
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

    @PostMapping("/adduser")
    public ResponseEntity<AddUserDto> addUser(@RequestBody FuelQuota fuelQuota){
        return ResponseEntity.ok(quotaService.addUser(fuelQuota));
    }

    @GetMapping("/all")  // Endpoint to get all fuel quotas
    public ResponseEntity<List<FuelQuota>> getAllQuotas() {
        List<FuelQuota> quotas = quotaService.findAllQuotas(); // Call service to fetch all quotas
        return ResponseEntity.ok(quotas); // Return the list of quotas
    }
}
