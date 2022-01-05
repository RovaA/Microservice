package com.example.demopayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPaymentApplication.class, args);
	}

}
