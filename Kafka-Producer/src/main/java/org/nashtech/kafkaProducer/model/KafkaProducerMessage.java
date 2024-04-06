package org.nashtech.kafkaProducer.model;

import lombok.Data;

@Data
public class KafkaProducerMessage {

    private String tenantId;
//    private T message;

    public KafkaProducerMessage(String tenantId) {
        this.tenantId = tenantId;
//        this.message = message;
    }

    public KafkaProducerMessage() {

    }
}
