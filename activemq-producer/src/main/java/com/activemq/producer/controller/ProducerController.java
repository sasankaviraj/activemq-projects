package com.activemq.producer.controller;

import com.activemq.common.constants.CommonConstants;
import com.activemq.common.enums.PublisherType;
import com.activemq.common.publisher.Publisher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sasanka Ariyaratna
 * @Date 3/19/2023
 * @Project activemq-producer
 */
@RestController
@RequestMapping("/send")
public class ProducerController {


    @PostMapping("/{name}")
    public String sendMessage(@PathVariable("name") String name) {
        Publisher.sendTextMessage(PublisherType.QUEUE, name, CommonConstants.SAMPLE_QUEUE);
        return "message sent to queue";
    }
}
