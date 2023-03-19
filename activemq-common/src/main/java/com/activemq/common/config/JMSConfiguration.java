package com.activemq.common.config;

import com.activemq.common.constants.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.jms.ConnectionFactory;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-producer
 */
@EnableAutoConfiguration
@ComponentScan
@EnableJms
@EnableTransactionManagement
public class JMSConfiguration {

    private static final String TYPE = "_type";

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean(name = CommonConstants.Q_JMS_TEMPLATE)
    public JmsTemplate getJmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDestinationResolver(new JndiDestinationResolver());
        jmsTemplate.setMessageConverter(jacksonJMSMessageConverter());
        jmsTemplate.setConnectionFactory(connectionFactory);
        return jmsTemplate;
    }

    public MessageConverter jacksonJMSMessageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);
        messageConverter.setTypeIdPropertyName(TYPE);
        return messageConverter;
    }
}
