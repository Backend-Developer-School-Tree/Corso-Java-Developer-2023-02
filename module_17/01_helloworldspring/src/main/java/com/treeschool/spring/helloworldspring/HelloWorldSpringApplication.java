package com.treeschool.spring.helloworldspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldSpringApplication {

	static Logger logger = LoggerFactory.getLogger(HelloWorldSpringApplication.class);

	public static void main(String[] args) {
		logger.info("*** SYSTEM STARTUP ***");

		SpringApplication.run(HelloWorldSpringApplication.class, args);

		logger.info("*** SYSTEM STARTUP - END ***");
	}

}
