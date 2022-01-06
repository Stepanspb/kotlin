package com.example.kotlin

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

@Component
class KafkaListener {

    @KafkaListener(id = "id", topics = ["topic1"], concurrency = "2")
    fun handleMessage(message: String?) {
        println("message is $message ${LocalDateTime.now()}")
    }
}