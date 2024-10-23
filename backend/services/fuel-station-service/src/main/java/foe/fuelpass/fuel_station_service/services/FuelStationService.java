package foe.fuelpass.fuel_station_service.services;

import foe.fuelpass.fuel_station_service.entities.FuelStation;
import foe.fuelpass.fuel_station_service.repositories.FuelStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuelStationService {

    private final FuelStationRepository fuelStationRepository;

    public List<FuelStation> findAll() {
        return fuelStationRepository.findAll();
    }

    public Optional<FuelStation> findById(Long id) {
        return fuelStationRepository.findById(id);
    }

    public FuelStation save(FuelStation fuelStation) {
        return fuelStationRepository.save(fuelStation);
    }

    public void deleteById(Long id) {
        fuelStationRepository.deleteById(id);
    }
}