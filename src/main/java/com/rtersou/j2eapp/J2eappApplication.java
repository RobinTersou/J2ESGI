package com.rtersou.j2eapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class J2eappApplication {

	public static void main(String[] args) {
		SpringApplication.run(J2eappApplication.class, args);
	}

}
