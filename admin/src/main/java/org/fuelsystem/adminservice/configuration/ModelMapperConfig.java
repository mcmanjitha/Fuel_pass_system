package org.fuelsystem.adminservice.configuration;

import org.fuelsystem.adminservice.model.DTO.FuelStationCreateDTO;
import org.fuelsystem.adminservice.model.FuelStation;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<FuelStationCreateDTO, FuelStation>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });

        return modelMapper;
    }
}
