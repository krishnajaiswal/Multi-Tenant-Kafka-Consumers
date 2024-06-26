package org.nashtech.kafkaProducer.producer;

import org.nashtech.kafkaProducer.model.KafkaProducerMessage;
import org.nashtech.kafkaProducer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonKafkaProducer {

    private String topicNamePrefix = "salary.multinenant_";
    private String topicName;
    private int salary;

    @Value("${spring.kafka.nashtech.topic.name}")
    private String nashtechTopicName;

    @Value("${spring.kafka.knoldus.topic.name}")
    private String knoldusTopicName;

    @Value("${spring.kafka.amway.topic.name}")
    private String amwayTopicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    List<String> topicList = new ArrayList<String>();
    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    User user = new User();
    KafkaProducerMessage kafkaProducerMessage = new KafkaProducerMessage();

    public void sendMessage(KafkaProducerMessage data, String tenantId){
        topicList.add(nashtechTopicName);
        topicList.add(knoldusTopicName);
        topicList.add(amwayTopicName);
        topicName = topicNamePrefix.concat(tenantId);
//        System.out.println(data.getName());

        if(topicList.contains(topicName)) {
//            LOGGER.info(String.format("Message sent -> %s", data.toString()));
//            kafkaMessage.setTenantId(tenantId);
//            kafkaMessage.setEmployeeId(data.getEmployeeId());
//            kafkaMessage.setName(data.getName());
//            salary = data.getNumberOfDaysWorked() * data.getBaseSalary() + data.getBonus() - data.getTaxDeduction();

//            kafkaMessage.setSalary(salary);
            Message<KafkaProducerMessage> message = MessageBuilder
                    .withPayload(data)
                    .setHeader(KafkaHeaders.TOPIC, topicName)
                    .build();
            kafkaTemplate.send(message);
        } else {
            System.out.println("Please enter a valid tenant id");
        }
    }
}
