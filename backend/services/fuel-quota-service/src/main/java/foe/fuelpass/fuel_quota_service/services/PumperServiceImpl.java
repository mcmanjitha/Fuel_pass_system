package foe.fuelpass.fuel_quota_service.services;

import foe.fuelpass.fuel_quota_service.Dto.PumperOutputDto;
import foe.fuelpass.fuel_quota_service.entities.Pumper;
import foe.fuelpass.fuel_quota_service.repositories.PumperRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PumperServiceImpl implements PumperService {
    private final PumperRepository pumperRepository;

    @Autowired
    public PumperServiceImpl(PumperRepository pumperRepository) {
        this.pumperRepository = pumperRepository;
    }

    @Override
    public PumperOutputDto savePumper(String username, String password) {
        Pumper pumper = new Pumper();
        pumper.setUsername(username);
        pumper.setPassword(password); // Use secure password storage (e.g., BCrypt) in production
        Pumper savedPumper = pumperRepository.save(pumper);

        PumperOutputDto outputDto = new PumperOutputDto();
        //outputDto.setId(savedPumper.getId());
        outputDto.setUsername(savedPumper.getUsername());
        outputDto.setMessage("Pumper added successfully!");

        return outputDto;
    }
}
