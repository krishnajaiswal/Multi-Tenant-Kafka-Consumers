package com.nashtech.multiTenancyKafka.controller;

import com.nashtech.multiTenancyKafka.kafka.KafkaProducer;
import com.nashtech.multiTenancyKafka.kafka.ThirdKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private ThirdKafkaProducer thirdKafkaProducer;

//    public MessageController(ThirdKafkaProducer thirdKafkaProducer) {
//        this.thirdKafkaProducer = thirdKafkaProducer;
//    }
//
//    public MessageController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

    // http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @GetMapping("/publish2")
    public ResponseEntity<String> publish2(@RequestParam("msg") String msg){
        thirdKafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
