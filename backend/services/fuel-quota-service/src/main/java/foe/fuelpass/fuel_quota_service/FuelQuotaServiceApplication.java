package foe.fuelpass.fuel_quota_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FuelQuotaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuelQuotaServiceApplication.class, args);
	}
}