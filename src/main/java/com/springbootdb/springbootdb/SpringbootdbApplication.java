package com.springbootdb.springbootdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringbootdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdbApplication.class, args);
	}

}
