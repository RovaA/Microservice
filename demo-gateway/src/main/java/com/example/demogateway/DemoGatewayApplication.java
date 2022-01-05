package com.example.demogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("auth-service", r -> r.path("/auth/**").uri("http://localhost:8089"))
				.route("client-service", r -> r.path("/client/**").uri("http://localhost:8082"))
				.route("payment-payment", r -> r.path("/payment/**").uri("http://localhost:8081"))
				.build();
	}

}
