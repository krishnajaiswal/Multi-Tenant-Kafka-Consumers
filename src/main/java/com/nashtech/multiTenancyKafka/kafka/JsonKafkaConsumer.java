//package com.nashtech.multiTenancyKafka.kafka;
//
//import com.nashtech.multiTenancyKafka.payload.JsonMessage;
//import com.nashtech.multiTenancyKafka.payload.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JsonKafkaConsumer {
//    @Value("${kafka.topic.prefix}")
//    private String topicPrefix;
//
//    @Value("${kafka.topic.groupId}")
//    private String groupId;
//
//    private String topic_prefix = "salary.multinenant_";
//    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
//
////    @KafkaListener(topicPattern = "${kafka.topic.prefix}.*", groupId = "${kafka.topic.groupId}")
////    @KafkaListener(topics = {"salary.multinenant_nashtech","salary.multinenant_knoldus","salary.multinenant_amway"}, groupId = "myGroup")
//    public void consume(JsonMessage user){
//        System.out.println();
//        String tenantId = user.getTenantId();
//        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
//        System.out.println("Tenant id = " + tenantId);
//    }
//}
