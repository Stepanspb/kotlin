package com.example.kotlin

import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.random.Random

@Service
class DelayMessageService (var externalServiceFeignClient: ExternalServiceFeignClient) {

    fun createMessagesAndSend(messagesCount: Int) {
        val createMessages = createMessages(messagesCount)
        for (message in createMessages) {
            externalServiceFeignClient.processMessage(message);
        }
    }


    private fun createMessages(messagesCount: Int): List<DelayedMessage> {
        val messages = mutableListOf<DelayedMessage>()
        for (i in 0..messagesCount) {
            val now = LocalDateTime.now();
            messages.add(DelayedMessage(i, now, generateRandomDelay(now)))
        }
        return messages
    }

    private fun generateRandomDelay(now : LocalDateTime) = now.plusSeconds(Random.nextLong(30))
}

data class DelayedMessage(val id: Int, val creationTime: LocalDateTime, val timeToPerform: LocalDateTime)