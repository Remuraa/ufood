package com.uemura.ufood;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UfoodApplication {

	private static final Logger logger = LoggerFactory.getLogger(UfoodApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UfoodApplication.class, args);
		logger.info("\n\nServiço inciado");
	}

}
