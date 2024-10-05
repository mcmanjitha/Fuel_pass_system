package architecture.project.fuelsystem.service;

import architecture.project.fuelsystem.model.DepartmentDatabase;
import architecture.project.fuelsystem.model.VehicleRegistration;
import architecture.project.fuelsystem.repository.DepartmentRepository;
import architecture.project.fuelsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService
{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * Validates if a vehicle exists in the department database using chassis number.
     *
     * @param chassisno - Vehicle's chassis number.
     * @return "Validated" if vehicle exists, "Not Validated" otherwise.
     */
    public String validate(String chassisno) {
        Optional<DepartmentDatabase> availableVehicle = departmentRepository.findById(chassisno);
        if (availableVehicle.isPresent()) {
            return "Validated";
        } else {
            return "Not Validated";
        }
    }

    /**
     * Registers a vehicle after validating it.
     *
     * @param vehicle - VehicleRegistration object to be registered.
     * @return The registered VehicleRegistration object.
     */
    public VehicleRegistration register(VehicleRegistration vehicle) {
        // Validate the vehicle before proceeding with registration
        String validationStatus = validate(vehicle.getChassisno());
        if (!validationStatus.equals("Validated")) {
            throw new IllegalArgumentException("Vehicle with chassis number " + vehicle.getChassisno() + " is not validated.");
        }

        // Check if the vehicle with the given chassis number already exists
        Optional<VehicleRegistration> existingVehicle = vehicleRepository.findById(vehicle.getChassisno());
        if (existingVehicle.isPresent()) {
            // Handle the case where the chassis number already exists
            throw new IllegalArgumentException("Vehicle with chassis number " + vehicle.getChassisno() + " already exists.");
        }

        // Save the vehicle if validation passes and it does not already exist
        return vehicleRepository.save(vehicle);
    }

    public String verify(VehicleRegistration vehicle) {
        // Implementation for verifying vehicle (if required)
        return null;
    }
}
