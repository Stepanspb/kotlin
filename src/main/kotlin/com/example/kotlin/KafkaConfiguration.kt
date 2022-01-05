package com.example.kotlin

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaTemplate

@Configuration
class KafkaConfiguration {

    @Bean
    fun topic(): NewTopic = TopicBuilder.name("topic1")
        .partitions(10)
        .replicas(1)
        .build();

}