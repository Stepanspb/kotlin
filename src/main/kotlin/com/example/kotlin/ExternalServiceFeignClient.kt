package com.example.kotlin

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.time.LocalDateTime

@FeignClient("externalService", url = "\${feign.client.config.externalService.url}")
interface ExternalServiceFeignClient {

    @PostMapping("/external")
    fun processMessage(@RequestBody message : DelayedMessage)

    @GetMapping("/external")
    fun getResults() : ResponseEntity<List<Result>>

    data class Result(val receivedAt: LocalDateTime, val externalMessage: DelayedMessage)
}