package org.fuelsystem.adminservice.service;

import org.fuelsystem.adminservice.model.DTO.VehicleRegistrationCreateDTO;
import org.fuelsystem.adminservice.model.DTO.VehicleRegistrationDTO;

import java.util.List;

public interface VehicleRegistrationService {
    List<VehicleRegistrationDTO> getAllVehicleRegistrations();
    VehicleRegistrationDTO getVehicleRegistrationById(String chassisNumber);
    VehicleRegistrationDTO createVehicleRegistration(VehicleRegistrationCreateDTO vehicleRegistrationCreateDTO);
    VehicleRegistrationDTO updateVehicleRegistration(String chassisNumber, VehicleRegistrationDTO vehicleRegistrationDTO);
    void deleteVehicleRegistration(String chassisNumber);
}
