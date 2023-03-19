package com.activemq.common.publisher;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-producer
 */
@Component
public class TopicPublisher implements Publishable{
    @Override
    public void sendObjectMessage(Serializable message, String resourceName) {

    }

    @Override
    public void sendTextMessage(String message, String resourceName) {

    }

    @Override
    public void sendTextMessage(String message, String resourceName, String jmsTemplate) {

    }

    @Override
    public void sendObjectAsJSON(Object message, String resourceName) {

    }

    @Override
    public void sendObjectAsJSONTransactional(Object message, String resourceName) {

    }
}
