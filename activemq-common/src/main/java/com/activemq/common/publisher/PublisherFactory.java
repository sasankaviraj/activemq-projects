package com.activemq.common.publisher;

import com.activemq.common.enums.PublisherType;
import com.activemq.common.config.AppContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-producer
 */
public class PublisherFactory {

    @Autowired
    static AppContext context;

    public static Publishable getPublisher(PublisherType publisherType){
        Publishable publishable = null;
        switch (publisherType){
            case QUEUE:
                publishable =  context.getBean(QueuePublisher.class);
                break;
            case TOPIC:
                publishable = context.getBean(TopicPublisher.class);
                break;
        }
        return publishable;
    }
}
