package com.nashtech.multiTenancyKafka.controller;


import com.nashtech.multiTenancyKafka.kafka.JsonKafkaProducer;
import com.nashtech.multiTenancyKafka.model.KafkaConsumerMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody KafkaConsumerMessage user, @RequestHeader("X-Tenant_Id") String tenantId){
        kafkaProducer.sendMessage(user, tenantId);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
