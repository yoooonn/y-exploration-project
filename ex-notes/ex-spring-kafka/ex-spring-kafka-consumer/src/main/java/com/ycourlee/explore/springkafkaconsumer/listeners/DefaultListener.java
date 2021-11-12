package com.ycourlee.explore.springkafkaconsumer.listeners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author yongjiang
 * @date 2021.08.04
 */
@Component
public class DefaultListener {

    private static final Logger log = LoggerFactory.getLogger(DefaultListener.class);

    @KafkaListener(topics = {"exp-test"}, groupId = "${spring.application.name}")
    public void onMessage(ConsumerRecord<String, String> message) {
        log.info("message: {}", message);
    }
}
