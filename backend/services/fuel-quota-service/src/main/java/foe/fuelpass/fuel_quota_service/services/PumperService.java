package foe.fuelpass.fuel_quota_service.services;

import foe.fuelpass.fuel_quota_service.Dto.PumperOutputDto;

public interface PumperService {
    PumperOutputDto savePumper(String username, String password);
}
