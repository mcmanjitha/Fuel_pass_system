package foe.fuelpass.fuel_station_service.controllers;

import foe.fuelpass.fuel_station_service.entities.FuelStation;
import foe.fuelpass.fuel_station_service.services.FuelStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
@RequiredArgsConstructor
public class FuelStationController {

    private final FuelStationService stationService;

    @GetMapping
    public ResponseEntity<List<FuelStation>> getAllStations() {
        return ResponseEntity.ok(stationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelStation> getStationById(@PathVariable Long id) {
        return stationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FuelStation> createStation(@RequestBody FuelStation station) {
        return ResponseEntity.ok(stationService.save(station));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        stationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}