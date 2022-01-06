package com.example.external.externalservice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("external")
class ExternalController {

    val list = mutableListOf<Result>()

    @PostMapping()
    fun processMessage(@RequestBody message : ExternalMessage) {
        list.add(message.id, Result(LocalDateTime.now(), message))
    }

    @GetMapping()
    fun getResults() : ResponseEntity<List<Result>> {
        return ResponseEntity.ok(list);
    }
}

data class ExternalMessage(val id: Int, val creationTime: LocalDateTime, val timeToPerform: LocalDateTime)
data class Result(val receivedAt: LocalDateTime, val externalMessage: ExternalMessage)