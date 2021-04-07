package com.cg.sbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SbsApplication.class, args);

	}
}