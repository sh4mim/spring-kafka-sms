package com.harun.springkafkasms.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic smsTopic() {
        //return new NewTopic("baeldung", 1, (short) 1);
        return TopicBuilder.name("sendSMS").replicas(1).partitions(1)
                .build();
    }
}
