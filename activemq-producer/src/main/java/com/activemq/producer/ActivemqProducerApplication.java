package com.activemq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.activemq.common", "com.activemq.producer"})
@PropertySource("application.yml")
public class ActivemqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqProducerApplication.class, args);
    }
}
