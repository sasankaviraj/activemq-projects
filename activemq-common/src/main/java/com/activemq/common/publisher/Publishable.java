package com.activemq.common.publisher;

import java.io.Serializable;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-producer
 */
public interface Publishable {
    /***
     * send object message
     * @param message
     * @param resourceName
     */
    void sendObjectMessage(Serializable message, String resourceName);

    /***
     * send text message
     * @param message
     * @param resourceName
     */
    void sendTextMessage(String message, String resourceName);

    /***
     * send object message
     * @param message
     * @param resourceName
     * @param jmsTemplate
     */
    void sendTextMessage(String message, String resourceName, String jmsTemplate);

    /***
     * send json message
     * @param message
     * @param resourceName
     */
    void sendObjectAsJSON(Object message, String resourceName);

    /***
     * send json message
     * @param message
     * @param resourceName
     */
    void sendObjectAsJSONTransactional(Object message, String resourceName);
}
