package com.aoa.notifyhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = {"com.aoa"})
@EnableJpaRepositories(basePackages = {"com.aoa"})
@ComponentScan(basePackages = {"com.aoa"})
@EnableScheduling
@SpringBootApplication
public class NotifyHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifyHubApplication.class, args);
	}

}
