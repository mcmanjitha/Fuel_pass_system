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

    public String validate(String chassisno) {
        Optional<DepartmentDatabase> availableVehicle = departmentRepository.findById(chassisno);
        if (availableVehicle.isPresent()) {
            return "Validated";
        }
        else
        {
            return "Not Validated";

        }

    }

    public VehicleRegistration register(VehicleRegistration vehicle) {
        // Check if the vehicle with the given chassisno already exists
        Optional<VehicleRegistration> existingVehicle = vehicleRepository.findById(vehicle.getChassisno());
        if (existingVehicle.isPresent()) {
            // Handle the case where the chassisno already exists
            throw new IllegalArgumentException("Vehicle with chassis number " + vehicle.getChassisno() + " already exists.");

        }
        // Save the vehicle if it does not exist
        return vehicleRepository.save(vehicle);
    }

    public String verify(VehicleRegistration vehicle)
    {
        return null;
    }


}
