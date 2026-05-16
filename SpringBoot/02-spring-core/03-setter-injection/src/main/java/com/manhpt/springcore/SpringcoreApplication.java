package com.manhpt.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringcoreApplication {
	// @SpringBootApplication is composed of: @EnableAutoConfiguration, @ComponentScan, @Configuration
	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}

}
