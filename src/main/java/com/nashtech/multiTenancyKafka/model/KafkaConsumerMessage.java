package com.nashtech.multiTenancyKafka.model;

import lombok.Data;

@Data
public class KafkaConsumerMessage<T> {

    private String tenantId;
    private T message;

    public KafkaConsumerMessage(String tenantId, T message) {
        this.tenantId = tenantId;
        this.message = message;
    }

    public KafkaConsumerMessage() {

    }
}
