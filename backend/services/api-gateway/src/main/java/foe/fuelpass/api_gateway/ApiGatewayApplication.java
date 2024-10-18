package foe.fuelpass.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("user-service", r -> r.path("/users/**")
						.uri("lb://user-service"))
				.route("vehicle-service", r -> r.path("/vehicles/**")
						.uri("lb://vehicle-service"))
				.route("fuel-station-service", r -> r.path("/fuelstations/**")
						.uri("lb://fuel-station-management-service"))
				.build();
	}
}