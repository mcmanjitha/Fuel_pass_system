package org.fuelsystem.adminservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.fuelsystem.adminservice.model.DTO.FuelStationCreateDTO;
import org.fuelsystem.adminservice.model.DTO.FuelStationDTO;
import org.fuelsystem.adminservice.service.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/fuel-stations")
public class FuelStationController {

    @Autowired
    private FuelStationService fuelStationService;

    @Operation(summary = "Create a new fuel station", description = "Create a new fuel station")
    @PostMapping("/create")
    public ResponseEntity<FuelStationDTO> createFuelStation(@RequestBody FuelStationCreateDTO fuelStationCreateDTO) {
        try {
            log.info("Creating fuel station: {}", fuelStationCreateDTO.getFuelStationName());
            FuelStationDTO fuelStationDTO = fuelStationService.createFuelStation(fuelStationCreateDTO);
            return new ResponseEntity<>(fuelStationDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Create fuel station failed");
        }
    }

    @Operation(summary = "Get all fuel stations", description = "Get all fuel stations")
    @GetMapping("/all")
    public ResponseEntity<List<FuelStationDTO>> getAllFuelStations() {
        try {
            return ResponseEntity.ok(fuelStationService.getAllFuelStations());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Get fuel station by id", description = "Get fuel station by id")
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<FuelStationDTO> getFuelStationById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(fuelStationService.getFuelStationById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Get fuel station by owner id", description = "Get fuel station by owner id")
    @GetMapping("/get-by-owner-id/{ownerId}")
    public ResponseEntity<FuelStationDTO> getFuelStationByOwnerId(@PathVariable String ownerId) {
        try {
            return ResponseEntity.ok(fuelStationService.getFuelStationByOwnerId(ownerId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Update fuel station", description = "Update fuel station")
    @PutMapping("/update/{id}")
    public ResponseEntity<FuelStationDTO> updateFuelStation(@PathVariable Long id,@RequestBody FuelStationDTO fuelStationDTO) {
        try {
            return ResponseEntity.ok(fuelStationService.updateFuelStation(id, fuelStationDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Delete fuel station", description = "Delete fuel station")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFuelStation(@PathVariable Long id) {
        try {
            fuelStationService.deleteFuelStation(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
