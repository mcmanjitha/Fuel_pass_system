package foe.fuelpass.fuel_station_service.services;

import foe.fuelpass.fuel_station_service.repositories.FuelStationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;
import foe.fuelpass.fuel_station_service.entities.FuelStation;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuelStationService {

    private final FuelStationRepository fuelStationRepository;
    private final RestTemplate restTemplate;
    String quotaServiceUrl = "http://fuel-quota-service/quota/test";

    public List<FuelStation> findAll() {
        return fuelStationRepository.findAll();
    }

    public void reachquota() {
        try {
            String response = restTemplate.getForObject("ls://fuel-quota-service/quota/test", String.class);

            System.out.println("Response from fuel-quota-service: " + response);
        } catch (Exception e) {
            System.err.println("Failed to call fuel-quota-service: " + e.getMessage());
        }
    }



    public Optional<FuelStation> findById(Long id) {
        return fuelStationRepository.findById(id);
    }

    public FuelStation save(FuelStation fuelStation) {
        FuelStation savedStation = fuelStationRepository.save(fuelStation);

        try {
            restTemplate.postForObject(quotaServiceUrl, savedStation, Void.class);
        } catch (Exception e) {
            // Log the error and proceed
            System.err.println("Failed to call fuel-quota-service: " + e.getMessage());
        }

        return savedStation;
    }

    public void deleteById(Long id) {
        fuelStationRepository.deleteById(id);
    }
}
