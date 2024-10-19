package foe.fuelpass.mtd_integration_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MtdIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtdIntegrationServiceApplication.class, args);
	}
}