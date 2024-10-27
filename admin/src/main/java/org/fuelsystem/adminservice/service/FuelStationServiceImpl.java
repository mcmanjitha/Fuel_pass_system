package org.fuelsystem.adminservice.service;

import org.fuelsystem.adminservice.model.DTO.FuelStationCreateDTO;
import org.fuelsystem.adminservice.model.DTO.FuelStationDTO;
import org.fuelsystem.adminservice.model.FuelStation;
import org.fuelsystem.adminservice.repository.FuelStationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuelStationServiceImpl implements FuelStationService {
    @Autowired
    private FuelStationRepository fuelStationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FuelStationDTO createFuelStation(FuelStationCreateDTO fuelStationCreateDTO) {
        FuelStation fuelStation = modelMapper.map(fuelStationCreateDTO, FuelStation.class);
        fuelStationRepository.save(fuelStation);
        return modelMapper.map(fuelStation, FuelStationDTO.class);
    }
    @Override
    public List<FuelStationDTO> getAllFuelStations() {
        return fuelStationRepository.findAll().stream()
                .map(fuelStation -> modelMapper.map(fuelStation, FuelStationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FuelStationDTO getFuelStationById(Long id) {
        FuelStation fuelStation = fuelStationRepository.findById(id).orElse(null);
        return modelMapper.map(fuelStation, FuelStationDTO.class);
    }

    @Override
    public FuelStationDTO getFuelStationByOwnerId(String ownerId) {
        Optional<FuelStation> fuelStation = fuelStationRepository.findByOwnerId(ownerId);
        return modelMapper.map(fuelStation, FuelStationDTO.class);
    }

    @Override
    public FuelStationDTO updateFuelStation(Long id, FuelStationDTO fuelStationDTO) {
        FuelStation fuelStation = modelMapper.map(fuelStationDTO, FuelStation.class);
        fuelStation.setId(id);
        fuelStation.setUpdatedBy(fuelStation.getUpdatedBy());
        fuelStation.setUpdatedDateTime(new Date());
        fuelStationRepository.save(fuelStation);
        return modelMapper.map(fuelStation, FuelStationDTO.class);
    }

    @Override
    public void deleteFuelStation(Long id) {
        fuelStationRepository.deleteById(id);
    }

}
