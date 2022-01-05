package com.example.kotlin

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaListener {

    @KafkaListener(id = "id", topics = ["topic1"])
    fun handleMessage(message: String?) {
        println("message is $message")
    }
}