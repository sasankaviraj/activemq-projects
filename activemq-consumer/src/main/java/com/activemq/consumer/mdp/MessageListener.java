package com.activemq.consumer.mdp;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-consumer
 */
@Component
public class MessageListener {

    @JmsListener(destination = "samplequeue")
    public void listener(String name){
        System.out.println("the message received by queue is : " + name);
    }
}
