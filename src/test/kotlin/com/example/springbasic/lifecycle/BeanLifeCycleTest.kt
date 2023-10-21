package com.example.springbasic.lifecycle

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class BeanLifeCycleTest {

    @Test
    @DisplayName("")
    fun `lifeCycleTest`() {
        // Arrange
        val ac: ConfigurableApplicationContext = AnnotationConfigApplicationContext(LifeCycleConfig::class.java)
        val client = ac.getBean(NetworkClient::class.java)

        // Act
        ac.close()

        // Assert

    }

    @Configuration
    class LifeCycleConfig {

        @Bean
        fun networkClient(): NetworkClient {
            val networkClient = NetworkClient()
            networkClient.setUrl("https://test.com")
            return networkClient
        }
    }
}