package foe.fuelpass.fuel_station_service.services;

import foe.fuelpass.fuel_station_service.entities.FuelStationWorker;
import foe.fuelpass.fuel_station_service.repositories.FuelStationWorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelStationWorkerService {

    private final FuelStationWorkerRepository workerRepository;

    public List<FuelStationWorker> findAll() {
        return workerRepository.findAll();
    }

    public FuelStationWorker save(FuelStationWorker worker) {
        return workerRepository.save(worker);
    }

    public void deleteById(Long id) {
        workerRepository.deleteById(id);
    }
}