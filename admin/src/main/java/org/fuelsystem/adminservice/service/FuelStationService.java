package org.fuelsystem.adminservice.service;

import org.fuelsystem.adminservice.model.DTO.FuelStationCreateDTO;
import org.fuelsystem.adminservice.model.DTO.FuelStationDTO;

import java.util.List;

public interface FuelStationService {
    List<FuelStationDTO> getAllFuelStations();
    FuelStationDTO getFuelStationById(Long id);
    FuelStationDTO getFuelStationByOwnerId(String ownerId);
    FuelStationDTO createFuelStation(FuelStationCreateDTO fuelStationCreateDTO);
    FuelStationDTO updateFuelStation(Long id, FuelStationDTO fuelStationDTO);
    void deleteFuelStation(Long id);
}
