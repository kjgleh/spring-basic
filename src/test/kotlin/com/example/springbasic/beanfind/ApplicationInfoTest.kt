package com.example.springbasic.beanfind

import com.example.springbasic.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition.ROLE_APPLICATION
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationInfoTest {

    private val sut = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("모든 빈 조회하기")
    fun `find all beans`() {
        // Arrange

        // Act
        sut.beanDefinitionNames.forEach {
            println("name: $it object: ${sut.getBean(it)}")
        }

        // Assert

    }

    @Test
    @DisplayName("애플리케이션 빈 조회하기")
    fun `find all application beans`() {
        // Arrange

        // Act
        sut.beanDefinitionNames.forEach {
            if (sut.getBeanDefinition(it).role == ROLE_APPLICATION) {
                println("name: $it object: ${sut.getBean(it)}")
            }
        }

        // Assert

    }
}