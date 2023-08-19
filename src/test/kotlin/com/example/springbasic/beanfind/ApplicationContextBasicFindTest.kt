package com.example.springbasic.beanfind

import com.example.springbasic.AppConfig
import com.example.springbasic.member.MemberService
import com.example.springbasic.member.MemberServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext


class ApplicationContextBasicFindTest {

    private val sut = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 이름으로 조회")
    fun `find by bean name`() {
        // Arrange

        // Act
        val actual = sut.getBean("memberService")

        // Assert
        assertThat(actual).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    fun `find by bean interface type`() {
        // Arrange

        // Act
        val actual = sut.getBean(MemberService::class.java)

        // Assert
        assertThat(actual).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    fun `find by bean class type`() {
        // Arrange

        // Act
        val actual = sut.getBean(MemberServiceImpl::class.java)

        // Assert
        assertThat(actual).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("잘못된 빈 이름으로 조회")
    fun `find by wrong bean name`() {
        // Arrange

        // Act
        val act = { sut.getBean("test") }

        // Assert
        assertThrows<NoSuchBeanDefinitionException> { act() }
    }
}