package foe.fuelpass.motor_traffic_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MotorTrafficServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotorTrafficServiceApplication.class, args);
	}
}