package com.example.kotlin

import com.fasterxml.jackson.databind.JsonDeserializer
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Service
class DelayedMessagesRouter(private val kafkaSender: KafkaSender) {

    fun route(delayedMessage : KafkaMessage) {
        val now = LocalDateTime.now()
        val timeToPerform = delayedMessage.timeToPerform
        val secondsBetween = ChronoUnit.SECONDS.between(now, timeToPerform);

        when {
            secondsBetween > 15 -> {
                kafkaSender.send("topic15", delayedMessage);
            }
            secondsBetween in 5..15 -> {
                kafkaSender.send("topic5", delayedMessage);
            }
            else -> {
                kafkaSender.send("topic1", delayedMessage)
            }
        }
    }
}