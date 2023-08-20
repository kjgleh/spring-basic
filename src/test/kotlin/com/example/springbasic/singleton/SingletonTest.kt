package com.example.springbasic.singleton

import com.example.springbasic.AppConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    fun `pure container without spring`() {
        // Arrange
        val sut = AppConfig()

        // Act
        val memberService1 = sut.memberService()
        val memberService2 = sut.memberService()

        // Assert
        assertThat(memberService1).isNotSameAs(memberService2)
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    fun `singleton service test`() {
        // Arrange

        // Act
        val singletonService1 = SingletonService.getInstance()
        val singletonService2 = SingletonService.getInstance()

        // Assert
        assertThat(singletonService1).isSameAs(singletonService2)
    }
}