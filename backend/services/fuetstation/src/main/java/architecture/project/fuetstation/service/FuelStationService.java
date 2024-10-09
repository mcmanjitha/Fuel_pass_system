package architecture.project.fuetstation.service;

import architecture.project.fuetstation.model.FuelStation;
import architecture.project.fuetstation.model.PetroleumDepartment;
import architecture.project.fuetstation.repository.FuelStationRepository;
import architecture.project.fuetstation.repository.PetroleumDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FuelStationService
{
    @Autowired
    private FuelStationRepository fuelStationRepository;

    @Autowired
    private PetroleumDepartmentRepository petroleumDepartmentRepository;

    public String validate(String fuelStationID)
    {
        return null;
    }

    public FuelStation register(FuelStation fuelStationID)
    {
        return null;
    }
}
