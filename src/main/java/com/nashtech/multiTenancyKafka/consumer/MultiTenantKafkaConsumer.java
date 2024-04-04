package com.nashtech.multiTenancyKafka.consumer;

import com.nashtech.multiTenancyKafka.model.KafkaConsumerMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class MultiTenantKafkaConsumer {

    @Value("${kafka.topic.prefix}")
    private String topicPrefix;
    @Value("${kafka.topic.groupId}")
    private String groupId;

    @KafkaListener(topicPattern = "${kafka.topic.prefix}.*", groupId = "${kafka.topic.groupId}")
    public void consume(KafkaConsumerMessage kafkaConsumerMessage,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String receivedTopic){
        System.out.println(receivedTopic);
        System.out.println(kafkaConsumerMessage.getTenantId());
        System.out.println(kafkaConsumerMessage.getMessage());

        //Write to database schema based on tenant id
    }

}