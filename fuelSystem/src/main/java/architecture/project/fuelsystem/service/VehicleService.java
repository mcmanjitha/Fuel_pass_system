package architecture.project.fuelsystem.service;
import architecture.project.fuelsystem.model.VehicleRegistration;
import architecture.project.fuelsystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService
{
    @Autowired
    private VehicleRepository vehicleRepository;


    public VehicleRegistration register(VehicleRegistration vehicle)
    {
        return null;
    }

    public String verify(VehicleRegistration vehicle)
    {
        return null;
    }
}
