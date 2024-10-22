package org.fuelsystem.adminservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.fuelsystem.adminservice.model.DTO.VehicleRegistrationCreateDTO;
import org.fuelsystem.adminservice.model.DTO.VehicleRegistrationDTO;
import org.fuelsystem.adminservice.service.VehicleRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-registration")
public class VehicleRegistrationController {

    @Autowired
    private VehicleRegistrationService vehicleRegistrationService;

    @Operation(summary = "Create a new vehicle registration", description = "Create a new vehicle registration")
    @PostMapping("/create")
    public ResponseEntity<VehicleRegistrationDTO> createVehicleRegistration(@RequestBody VehicleRegistrationCreateDTO vehicleRegistrationCreateDTO){
        try {
            VehicleRegistrationDTO vehicleRegistrationDTO = vehicleRegistrationService.createVehicleRegistration(vehicleRegistrationCreateDTO);
            return new ResponseEntity<>(vehicleRegistrationDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Create Vehicle Registration Failed");
        }
    }

    @Operation(summary = "Get all vehicle registrations", description = "Get all vehicle registrations")
    @GetMapping("/all")
    public ResponseEntity<List<VehicleRegistrationDTO>> getAllVehicleRegistrations(){
        try {
            return ResponseEntity.ok(vehicleRegistrationService.getAllVehicleRegistrations());
        } catch (Exception e) {
            throw new RuntimeException("Get All Vehicle Registrations Failed");
        }
    }

    @Operation(summary = "Get vehicle registration by chassis number", description = "Get vehicle registration by chassis number")
    @GetMapping("/get-by-chassis-number/{chassisNumber}")
    public ResponseEntity<VehicleRegistrationDTO> getVehicleRegistrationByChassisNumber(@PathVariable String chassisNumber){
        try {
            return ResponseEntity.ok(vehicleRegistrationService.getVehicleRegistrationById(chassisNumber));
        } catch (Exception e) {
            throw new RuntimeException("Get Vehicle Registration Failed");
        }
    }

    @Operation(summary = "Update vehicle registration", description = "Update vehicle registration")
    @PutMapping("/update/{chassisNumber}")
    public ResponseEntity<VehicleRegistrationDTO> updateVehicleRegistration(@PathVariable String chassisNumber, @RequestBody VehicleRegistrationDTO vehicleRegistrationDTO){
        try {
            return ResponseEntity.ok(vehicleRegistrationService.updateVehicleRegistration(chassisNumber, vehicleRegistrationDTO));
        } catch (Exception e) {
            throw new RuntimeException("Update Vehicle Registration Failed");
        }
    }

    @Operation(summary = "Delete vehicle registration", description = "Delete vehicle registration")
    @DeleteMapping("/delete/{chassisNumber}")
    public ResponseEntity<Void> deleteVehicleRegistration(@PathVariable String chassisNumber){
        try {
            vehicleRegistrationService.deleteVehicleRegistration(chassisNumber);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException("Delete Vehicle Registration Failed");
        }
    }

}
