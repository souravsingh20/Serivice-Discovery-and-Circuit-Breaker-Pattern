package com.quinbay.ecommerce.seller_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
public class SellerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerMicroserviceApplication.class, args);
	}

	@Bean
    @LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
