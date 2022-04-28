package com.example.websocketrabbitmqdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.websocketrabbitmqdemo.dao.repositroy")

public class WebsocketRabbitmqDemoApplication {

	public static void main(String[] args) {
		SpringApplication
				.run(WebsocketRabbitmqDemoApplication.class, args);
	}


}
