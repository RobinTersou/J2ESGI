package com.rtersou.j2eproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class J2eprojectApplication extends SpringBootServletInitializer  {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(J2eprojectApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(J2eprojectApplication.class, args);
	}

}
