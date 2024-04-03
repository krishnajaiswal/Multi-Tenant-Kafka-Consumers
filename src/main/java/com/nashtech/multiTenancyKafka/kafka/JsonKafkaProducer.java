package com.nashtech.multiTenancyKafka.kafka;

import com.nashtech.multiTenancyKafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonKafkaProducer {

    private String topicNamePrefix = "salary.multinenant_";

    private String topicName;

    @Value("${spring.kafka.nashtech.topic.name}")
    private String nashtechTopicName;

    @Value("${spring.kafka.knoldus.topic.name}")
    private String knoldusTopicName;

    @Value("${spring.kafka.amway.topic.name}")
    private String amwayTopicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    List<String> topicList = new ArrayList<>(Arrays.asList(nashtechTopicName, knoldusTopicName, amwayTopicName));

//    String[] allTopics = { nashtechTopicName, knoldusTopicName, amwayTopicName };

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data, String tenantId){
        topicName = topicNamePrefix.concat(tenantId);
        if(topicList.contains(topicName)) {
            LOGGER.info(String.format("Message sent -> %s", data.toString()));
            Message<User> message = MessageBuilder
                    .withPayload(data)
                    .setHeader(KafkaHeaders.TOPIC, nashtechTopicName)
                    .build();
            kafkaTemplate.send(message);
        } else {
            System.out.println("Please enter a valid tenant id");
        }
    }
}
