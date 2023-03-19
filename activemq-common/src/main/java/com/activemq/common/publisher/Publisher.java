package com.activemq.common.publisher;

import com.activemq.common.enums.PublisherType;

import java.io.Serializable;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-producer
 */
public class Publisher {

    /***
     * send object message
     * @param publisherType
     * @param message
     * @param qName
     */
    public static void sendObjectMessage(PublisherType publisherType, Serializable message, String qName){
        Publishable publisher = PublisherFactory.getPublisher(publisherType);
        publisher.sendObjectAsJSON(message, qName);
    }

    /***
     * send text message
     * @param publisherType
     * @param message
     * @param qName
     */
    public static void sendTextMessage(PublisherType publisherType, String message, String qName){
        Publishable publisher = PublisherFactory.getPublisher(publisherType);
        publisher.sendTextMessage(message, qName);
    }

    /***
     * send text message
     * @param publisherType
     * @param message
     * @param qName
     * @param jmsTemplate
     */
    public static void sendTextMessage(PublisherType publisherType, String message, String qName, String jmsTemplate){
        Publishable publisher = PublisherFactory.getPublisher(publisherType);
        publisher.sendTextMessage(message, qName, jmsTemplate);
    }

    /***
     * send object as JSON
     * @param publisherType
     * @param message
     * @param qName
     */
    public static void sendObjectAsJSON(PublisherType publisherType, Object message, String qName){
        Publishable publisher = PublisherFactory.getPublisher(publisherType);
        publisher.sendObjectAsJSON(message, qName);
    }

    /***
     * send object as JSON transactional
     * @param publisherType
     * @param message
     * @param qName
     */
    public static void sendObjectAsJSONTransactional(PublisherType publisherType, Object message, String qName){
        Publishable publisher = PublisherFactory.getPublisher(publisherType);
        publisher.sendObjectAsJSONTransactional(message, qName);
    }
}
