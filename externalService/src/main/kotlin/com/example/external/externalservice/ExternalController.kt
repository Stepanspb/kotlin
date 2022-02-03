package com.example.external.externalservice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("external")
class ExternalController {

    val list = arrayOfNulls<Result>(6000)

    @PostMapping()
    fun processMessage(@RequestBody message : ExternalMessage) {
        list[message.id] = Result(LocalDateTime.now(), message)
    }

    @GetMapping()
    fun getResults() : ResponseEntity<Array<Result?>> {
        return ResponseEntity.ok(list);
    }

    @GetMapping("/count")
    fun getCount() : ResponseEntity<Int> {
        val notNullElements = list.filterNotNull();
        return ResponseEntity.ok(notNullElements.size)
    }
}

data class ExternalMessage(val id: Int, val creationTime: LocalDateTime, var timeToPerform: LocalDateTime?)
data class Result(val receivedAt: LocalDateTime, val externalMessage: ExternalMessage)