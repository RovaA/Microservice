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
				//.route("client", r -> r.path("/").uri("http://localhost:8082"))
				.route("client_send_message", r -> r.path("/sendMessage").uri("http://localhost:8082/sendMessage"))
				.route("payment", r -> r.path("/api/commands").uri("http://localhost:8081"))
				.route("payment_test", r -> r.path("/test").uri("http://localhost:8081/api/commands"))
				.build();
	}

}
