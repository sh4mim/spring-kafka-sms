package com.harun.springkafkasms;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "sendSMS", groupId = "spring.kafka.consumer.group-id")
    void listener(String data) {
        System.out.println("Listener received: " + data + " ££");
    }
}
