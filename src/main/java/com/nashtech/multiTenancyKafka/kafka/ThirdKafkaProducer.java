package com.nashtech.multiTenancyKafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ThirdKafkaProducer {

    @Value("${spring.kafka.amway.topic.name}")
    private String thirdTopicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdKafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public ThirdKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send(thirdTopicName, message);
    }
}
