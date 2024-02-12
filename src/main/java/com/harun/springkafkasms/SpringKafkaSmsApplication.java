package com.harun.springkafkasms;

import com.harun.springkafkasms.bean.SmsRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaSmsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
                kafkaTemplate.send("sendSMS", "Hello Kafka! - A Sample Text");
        };
    }

    @Bean
    CommandLineRunner commandLineSmsRequestRunner(KafkaTemplate<String, SmsRequest> smsKafkaTemplate) {
        return args -> {
            smsKafkaTemplate.send("sendSMSOtp", SmsRequest.builder()
                    .recipient("01714345644")
                    .sender("SmsGenie")
                    .text("Sending the Genie with a Greeting!")
                    .build());
        };
    }

}
