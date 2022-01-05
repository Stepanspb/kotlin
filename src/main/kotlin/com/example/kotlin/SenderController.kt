package com.example.kotlin

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("sender")
class SenderController (val sender : KafkaSender) {

    @GetMapping("/{message}")
    fun sendMessageToKafka (@PathVariable("message") message : String) : ResponseEntity<String> {
        sender.send(message);
        return ResponseEntity.ok("ok");
    }

}