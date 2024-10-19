package foe.fuelpass.fuel_station_service.controllers;

import foe.fuelpass.fuel_station_service.entities.FuelStationWorker;
import foe.fuelpass.fuel_station_service.services.FuelStationWorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@RequiredArgsConstructor
public class FuelStationWorkerController {

    private final FuelStationWorkerService workerService;

    @GetMapping
    public ResponseEntity<List<FuelStationWorker>> getAllWorkers() {
        return ResponseEntity.ok(workerService.findAll());
    }

    @PostMapping
    public ResponseEntity<FuelStationWorker> createWorker(@RequestBody FuelStationWorker worker) {
        return ResponseEntity.ok(workerService.save(worker));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        workerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}