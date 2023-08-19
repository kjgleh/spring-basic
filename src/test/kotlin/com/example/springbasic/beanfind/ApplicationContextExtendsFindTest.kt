package com.example.springbasic.beanfind

import com.example.springbasic.discount.DiscountPolicy
import com.example.springbasic.discount.FixDiscountPolicy
import com.example.springbasic.discount.RateDiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean


class ApplicationContextExtendsFindTest {

    private val sut = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상이면 중복오류가 발생한다.")
    fun `findBeanByParentTypeDuplicate`() {
        // Arrange

        // Act
        val act = { sut.getBean(DiscountPolicy::class.java) }

        // Assert
        assertThrows<NoUniqueBeanDefinitionException> { act() }
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면 빈 이름을 지정하면 된다")
    fun `find bean by name`() {
        val rateDiscountPolicy: DiscountPolicy = sut.getBean(
            "rateDiscountPolicy",
            DiscountPolicy::class.java
        )
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy::class.java)
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    fun `find bean by parent type`() {
        // Arrange

        // Act
        val actual = sut.getBeansOfType(DiscountPolicy::class.java)

        // Assert
        assertThat(actual).hasSize(2)
        println(actual)
    }

    @TestConfiguration
    class TestConfig {

        @Bean
        fun fixDiscountPolicy(): DiscountPolicy {
            return FixDiscountPolicy()
        }

        @Bean
        fun rateDiscountPolicy(): DiscountPolicy {
            return RateDiscountPolicy()
        }
    }
}