package foe.fuelpass.fuel_quota_service.controllers;

import com.netflix.discovery.converters.Auto;
import foe.fuelpass.fuel_quota_service.Dto.PumperInputDto;
import foe.fuelpass.fuel_quota_service.Dto.PumperOutputDto;
import foe.fuelpass.fuel_quota_service.services.PumperService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pumper")
public class PumperController {

    private final PumperService pumperService;

    @Autowired
    public PumperController(PumperService pumperService) {
        this.pumperService = pumperService;
    }

    @PostMapping("/addStation")
    public ResponseEntity<PumperOutputDto> addStation(@RequestBody PumperInputDto inputDto) {
        PumperOutputDto response = pumperService.savePumper(inputDto.getUsername(), inputDto.getPassword());
        return ResponseEntity.ok(response);
    }
}
