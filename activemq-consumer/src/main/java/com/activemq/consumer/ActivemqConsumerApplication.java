package com.activemq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.yml")
public class ActivemqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqConsumerApplication.class, args);
	}

}
