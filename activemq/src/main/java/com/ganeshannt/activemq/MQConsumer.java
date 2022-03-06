package com.ganeshannt.activemq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MQConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(MQConsumer.class);

    @JmsListener(destination = "samplequeue")
    public String consumeMessage(MyMessage myMessage) {
        LOGGER.info("Message received! {}", myMessage);
        System.out.println(myMessage.getMessage());
        return myMessage.getMessage();
    }
}
