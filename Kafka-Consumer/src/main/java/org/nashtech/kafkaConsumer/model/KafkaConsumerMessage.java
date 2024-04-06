package org.nashtech.kafkaConsumer.model;

import lombok.Data;

@Data
public class KafkaConsumerMessage {

    private String tenantId;
//    private T message;

    public KafkaConsumerMessage(String tenantId) {
        this.tenantId = tenantId;
//        this.message = message;
    }

    public KafkaConsumerMessage() {

    }
}
