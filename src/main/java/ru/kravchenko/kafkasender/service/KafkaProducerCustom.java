package ru.kravchenko.kafkasender.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerCustom {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message, String topic) {
        log.info("Start send messsage to topic: " + topic);
        kafkaTemplate.send(topic, "key", message)
                .addCallback(
                        result -> log.info("Message success send to topic '{}': \n {}", topic, message),
                        ex -> log.error("Failed to send message", ex)
                );
    }

}
