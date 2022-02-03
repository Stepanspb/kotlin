package com.example.kotlin

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.time.LocalDateTime

@FeignClient("externalService", url = "\${feign.client.config.externalService.url}")
@CircuitBreaker(name = "externalService")
@RateLimiter(name = "externalService")
interface ExternalServiceFeignClient {

    @PostMapping("/external")
    fun processMessage(@RequestBody message : KafkaMessage)

    @GetMapping("/external")
    fun getResults() : ResponseEntity<List<Result>>

    data class Result(val receivedAt: LocalDateTime, val externalMessage: KafkaMessage)
}