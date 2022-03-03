package com.ganeshannt.kafka;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ganeshan Nagarajan
 * @since 02-03-2022
 */

public class ConsumerConfig {

    @Value("${kafka.broker.address}")
    private String kafka_broker_address;

    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        Map<String,Object> consumerConfigProps = new HashMap<>();
        consumerConfigProps.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka_broker_address);
        consumerConfigProps.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,"consumer-group");
        consumerConfigProps.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfigProps.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        return  new DefaultKafkaConsumerFactory<>(consumerConfigProps);
    }
}
