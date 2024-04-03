package com.nashtech.multiTenancyKafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.nashtech.topic.name}")
    private String nashtechTopicName;

    @Value("${spring.kafka.knoldus.topic.name}")
    private String knoldusTopicName;

    @Value("${spring.kafka.amway.topic.name}")
    private String amwayTopicName;

    @Bean
    public NewTopic firstTopic(){
        return TopicBuilder.name(nashtechTopicName)
                .build();
    }

    @Bean
    public NewTopic secondJsonTopic(){
        return TopicBuilder.name(knoldusTopicName)
                .build();
    }

    @Bean
    public NewTopic thirdTopic() {
        return TopicBuilder.name(amwayTopicName)
                .build();
    }
}
