package foe.fuelpass.fuel_station_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FuelStationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuelStationServiceApplication.class, args);
	}
}