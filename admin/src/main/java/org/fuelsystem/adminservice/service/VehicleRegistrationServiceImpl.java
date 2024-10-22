package org.fuelsystem.adminservice.service;

import org.fuelsystem.adminservice.model.DTO.VehicleRegistrationCreateDTO;
import org.fuelsystem.adminservice.model.DTO.VehicleRegistrationDTO;
import org.fuelsystem.adminservice.model.VehicleRegistration;
import org.fuelsystem.adminservice.repository.VehicleRegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleRegistrationServiceImpl implements VehicleRegistrationService{

    @Autowired
    private VehicleRegistrationRepository vehicleRegistrationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VehicleRegistrationDTO createVehicleRegistration(VehicleRegistrationCreateDTO vehicleRegistrationCreateDTO) {
        VehicleRegistration vehicleRegistration = modelMapper.map(vehicleRegistrationCreateDTO, VehicleRegistration.class);
        vehicleRegistrationRepository.save(vehicleRegistration);
        return modelMapper.map(vehicleRegistration, VehicleRegistrationDTO.class);
    }

    @Override
    public VehicleRegistrationDTO getVehicleRegistrationById(String chassisNumber) {
        VehicleRegistration vehicleRegistration = vehicleRegistrationRepository.findById(chassisNumber).orElse(null);
        return modelMapper.map(vehicleRegistration, VehicleRegistrationDTO.class);
    }

    @Override
    public VehicleRegistrationDTO updateVehicleRegistration(String chassisNumber, VehicleRegistrationDTO vehicleRegistrationDTO) {
        VehicleRegistration vehicleRegistration = modelMapper.map(vehicleRegistrationDTO, VehicleRegistration.class);
        vehicleRegistration.setChassisNumber(chassisNumber);
        vehicleRegistration.setUpdatedBy(vehicleRegistration.getUpdatedBy());
        vehicleRegistration.setUpdatedDateTime(new Date());
        vehicleRegistrationRepository.save(vehicleRegistration);
        return modelMapper.map(vehicleRegistration, VehicleRegistrationDTO.class);
    }

    @Override
    public void deleteVehicleRegistration(String chassisNumber) {
        vehicleRegistrationRepository.deleteById(chassisNumber);
    }

    @Override
    public List<VehicleRegistrationDTO> getAllVehicleRegistrations() {
        return vehicleRegistrationRepository.findAll().stream()
                .map(vehicleRegistration -> modelMapper.map(vehicleRegistration, VehicleRegistrationDTO.class))
                .collect(Collectors.toList());
    }


}
