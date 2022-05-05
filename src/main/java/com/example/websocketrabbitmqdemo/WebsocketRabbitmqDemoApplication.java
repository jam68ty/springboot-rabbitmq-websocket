package com.example.websocketrabbitmqdemo;

import com.example.websocketrabbitmqdemo.service.DialogueService;
import com.example.websocketrabbitmqdemo.service.impl.DialogueServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@EnableJpaRepositories("com.example.websocketrabbitmqdemo.dao.repositroy")
@EnableWebMvc
public class WebsocketRabbitmqDemoApplication {

	public static void main(String[] args) {
		SpringApplication
				.run(WebsocketRabbitmqDemoApplication.class, args);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	@Bean
	public DialogueService dialogueService(){
		return new DialogueServiceImpl();
	}

}
