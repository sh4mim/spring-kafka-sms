package com.harun.springkafkasms.listeners;

import com.harun.springkafkasms.bean.SmsRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "sendSMS", groupId = "spring.kafka.consumer.group-id")
    void listener(String data) {
        System.out.println("Listener received: " + data + " ££");
    }

    @KafkaListener(topics = "sendSMSOtp", groupId = "spring.kafka.consumer.group-id", containerFactory = "smsKafkaListenerContainerFactory")
    void listenerSmsOtp(SmsRequest smsRequest) {
        System.out.println("Listener received: " + smsRequest.toString() + " ££");
    }
}
