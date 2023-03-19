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

    public static Publishable getPublisher(PublisherType publisherType){
        Publishable publishable = null;
        switch (publisherType){
            case QUEUE:
                publishable =  AppContext.getBean(QueuePublisher.class);
                break;
            case TOPIC:
                publishable = AppContext.getBean(TopicPublisher.class);
                break;
        }
        return publishable;
    }
}
