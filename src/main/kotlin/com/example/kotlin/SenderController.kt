package com.example.kotlin

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("sender")
class SenderController(val delayMessageService : DelayMessageService) {

    @GetMapping("/{count}")
    fun sendMessageToKafka(@PathVariable("count") count: Int): ResponseEntity<String> {
        delayMessageService.createMessagesAndSend(count)
        return ResponseEntity.ok("ok");
    }
}