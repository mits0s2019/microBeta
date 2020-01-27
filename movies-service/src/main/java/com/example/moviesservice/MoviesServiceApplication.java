package com.example.moviesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true,
//		securedEnabled = true,
//		jsr250Enabled = true)
@EnableDiscoveryClient
public class MoviesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesServiceApplication.class, args);
	}

}
