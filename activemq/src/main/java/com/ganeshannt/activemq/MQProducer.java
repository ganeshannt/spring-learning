package com.ganeshannt.activemq;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MQProducer {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private MQConsumer mqConsumer;

    @PostMapping(path = "/api/produce")
    public ResponseEntity<String> publishMessageAPI(@RequestBody String myMessage) {
        System.out.println("inside producer" + myMessage);
        try {
            jmsTemplate.convertAndSend("t24TWSQueue", myMessage);
            return new ResponseEntity<>("send", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}