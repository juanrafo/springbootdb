package com.springbootdb.springbootdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.springbootdb.springbootdb", "controller" })*/
@Configuration
@ComponentScan({ "com.springbootdb.springbootdb", "controller" })
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringbootdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdbApplication.class, args);
	}

}
