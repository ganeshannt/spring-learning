package com.ganeshannt.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ganeshan Nagarajan
 * @since 23-02-2022
 */

@RestController
@RequestMapping("/produce/")
public class ProducerController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping("/{message}")
    public String produceMessage(@PathVariable("message") String message) {
        for (int i = 0; i < 10; i++) {
            String value = "message" + i;
            kafkaTemplate.send("third-topic", value);
        }
//        kafkaTemplate.send("first-topic message ",message);
        return "producer message " + message;
    }
}
