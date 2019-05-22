package com.rtersou.j2eproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


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
