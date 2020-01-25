package com.example.uiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableGlobalMethodSecurity(
//		prePostEnabled = true,
//		securedEnabled = true,
//		jsr250Enabled = true)
public class UiAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiAdminApplication.class, args);
	}

@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
