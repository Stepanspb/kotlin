package com.example.kotlin

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfiguration {

    @Bean
    fun topic1Second(): NewTopic = TopicBuilder.name("topic1")
        .partitions(1)
        .replicas(1)
        .build();

    @Bean
    fun topic5Second(): NewTopic = TopicBuilder.name("topic5")
        .partitions(1)
        .replicas(1)
        .build();

    @Bean
    fun topic15Second(): NewTopic = TopicBuilder.name("topic15")
        .partitions(1)
        .replicas(1)
        .build();

}