package com.example.kotlin

import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.random.Random

@Service
class DelayMessageService(
    val externalServiceFeignClient: ExternalServiceFeignClient,
    val delayedMessagesRouter: DelayedMessagesRouter
) {

    fun sendMessages(messages: List<KafkaMessage>) {
        for (message in messages) {
            try {
                externalServiceFeignClient.processMessage(message);
                println("message $message was send ${LocalDateTime.now()}")
            } catch (ex: Exception) {
                println("exception $ex")
                if (message.timeToPerform == null || message.timeToPerform!!.isBefore(LocalDateTime.now())) {
                    message.timeToPerform = generateRandomDelay();
                }
                delayedMessagesRouter.route(message)
            }
        }
    }

    private fun generateRandomDelay() = LocalDateTime.now().plusSeconds(Random.nextLong(100))

}