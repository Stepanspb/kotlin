package com.example.kotlin

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("sender")
class SenderController(val delayMessageService : DelayMessageService) {

    @GetMapping("/{count}")
    fun sendMessageToKafka(@PathVariable("count") count: Int): ResponseEntity<String> {
        val messages = createMessages(count)
        delayMessageService.sendMessages(messages)
        return ResponseEntity.ok("ok");
    }

    private fun createMessages(messagesCount: Int): List<KafkaMessage> {
        val messages = mutableListOf<KafkaMessage>()
        for (i in 0..messagesCount) {
            val now = LocalDateTime.now();
            messages.add(KafkaMessage(i, now, null))
        }
        return messages
    }

}