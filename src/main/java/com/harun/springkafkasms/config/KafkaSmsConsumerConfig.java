package com.harun.springkafkasms.config;

import com.harun.springkafkasms.bean.SmsRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Harun Rashid
 * User:shami
 * Date:12/02/2024
 * Time:01:59
 */
@EnableKafka
@Configuration
public class KafkaSmsConsumerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    public Map<String, Object> smsConsumerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return props;
    }

    @Bean
    public ConsumerFactory<String, SmsRequest> smsConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(smsConsumerConfig(), new StringDeserializer(), new JsonDeserializer<>(SmsRequest.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SmsRequest> smsKafkaListenerContainerFactory(ConsumerFactory<String, SmsRequest> smsConsumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, SmsRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(smsConsumerFactory);
        return factory;
    }

}
