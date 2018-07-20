package com.cardlinesrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduledTaksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledTaksApplication.class, args);
	}
}
