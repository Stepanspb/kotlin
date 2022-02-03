package com.example.kotlin

import java.time.LocalDateTime

open class KafkaMessage(val id: Int, val creationTime: LocalDateTime, var timeToPerform: LocalDateTime?) {

    override fun toString(): String {
        return "KafkaMessage(id=$id, creationTime=$creationTime, timeToPerform=$timeToPerform)"
    }
}