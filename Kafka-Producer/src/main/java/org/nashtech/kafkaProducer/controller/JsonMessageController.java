package org.nashtech.kafkaProducer.controller;

import org.nashtech.kafkaProducer.model.KafkaProducerMessage;
import org.nashtech.kafkaProducer.producer.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody KafkaProducerMessage user, @RequestHeader("X-Tenant_Id") String tenantId){
        kafkaProducer.sendMessage(user, tenantId);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
