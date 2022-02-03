package com.example.kotlin

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

@Component
class KafkaListener(
    private val delayMessageService: DelayMessageService,
    private val delayedMessagesRouter: DelayedMessagesRouter
) {

    @KafkaListener(id = "id1", topics = ["topic1"], concurrency = "2")
    fun handleMessage1SecondTopic(message: KafkaMessage) {
        val now = LocalDateTime.now();

        if (now.isAfter(message.timeToPerform)) {
            delayMessageService.sendMessages(listOf(message))
        } else {
            delayedMessagesRouter.route(message);
        }
    }

    @KafkaListener(id = "id5", topics = ["topic5"], concurrency = "2")
    fun handleMessage5SecondTopic(message: KafkaMessage) {
        val now = LocalDateTime.now();

        if (now.isAfter(message.timeToPerform)) {
            delayMessageService.sendMessages(listOf(message))
        } else {
            delayedMessagesRouter.route(message);
        }
    }

    @KafkaListener(id = "id15", topics = ["topic15"], concurrency = "2")
    fun handleMessage15SecondTopic(message: KafkaMessage) {
        val now = LocalDateTime.now();

        if (now.isAfter(message.timeToPerform)) {
            delayMessageService.sendMessages(listOf(message))
        } else {
            delayedMessagesRouter.route(message);
        }
    }
}