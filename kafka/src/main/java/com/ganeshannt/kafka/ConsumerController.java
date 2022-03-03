package com.ganeshannt.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Ganeshan Nagarajan
 * @since 25-02-2022
 */

@Component
public class ConsumerController {

    @KafkaListener(topics = "third-topic", groupId = "consumer-group")
    public void consumerEvents(String message) {
        System.out.println("consumed message " + message);
    }
}
