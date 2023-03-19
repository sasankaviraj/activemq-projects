package com.activemq.common.publisher;

import com.activemq.common.config.AppContext;
import com.activemq.common.constants.CommonConstants;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-producer
 */
@Component
public class QueuePublisher implements Publishable{

    private JmsTemplate qJmsTemplate;

    @Override
    public void sendObjectMessage(Serializable message, String qName) {
        qJmsTemplate = AppContext.getBean(CommonConstants.Q_JMS_TEMPLATE, JmsTemplate.class);
        qJmsTemplate.send(qName, session -> session.createObjectMessage(message));
    }

    @Override
    public void sendTextMessage(String message, String qName) {
        sendTextMessage(message, qName, null);
    }

    @Override
    public void sendTextMessage(String message, String qName, String jmsTemplate) {
        if(Objects.isNull(jmsTemplate)){
            jmsTemplate =CommonConstants. Q_JMS_TEMPLATE;
        }
//        qJmsTemplate = AppContext.getBean(jmsTemplate, JmsTemplate.class);
        qJmsTemplate = AppContext.getBean(JmsTemplate.class);
        qJmsTemplate.send(qName, session -> session.createObjectMessage(message));
    }

    @Override
    public void sendObjectAsJSON(Object message, String qName) {
        qJmsTemplate = AppContext.getBean(CommonConstants.Q_JMS_TEMPLATE, JmsTemplate.class);
        qJmsTemplate.convertAndSend(qName, message);
    }

    @Override
    public void sendObjectAsJSONTransactional(Object message, String qName) {
        qJmsTemplate = AppContext.getBean(CommonConstants.Q_JMS_TEMPLATE, JmsTemplate.class);
        qJmsTemplate.convertAndSend(qName, message);
    }
}
