package com.example.kotlin

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class KafkaSender(private var kafkaTemplate: KafkaTemplate<String, KafkaMessage>) {

    fun send(topic: String, message: KafkaMessage) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), message);
    }
}