package com.example.kotlin

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaSender (var kafkaTemplate : KafkaTemplate<String?, String?>) {

    fun send (message : String)  {
        kafkaTemplate.send("topic1", message);
    }
}