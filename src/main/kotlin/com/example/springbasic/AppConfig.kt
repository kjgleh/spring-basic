package com.example.springbasic

import com.example.springbasic.discount.DiscountPolicy
import com.example.springbasic.discount.FixDiscountPolicy
import com.example.springbasic.member.MemberRepository
import com.example.springbasic.member.MemberService
import com.example.springbasic.member.MemberServiceImpl
import com.example.springbasic.member.MemoryMemberRepository
import com.example.springbasic.order.OrderService
import com.example.springbasic.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun memberService(): MemberService {
        return MemberServiceImpl(
            memberRepository(),
        )
    }

    @Bean
    fun orderService(): OrderService {
        return OrderServiceImpl(
            memberRepository(),
            discountPolicy()
        )
    }

    @Bean
    fun memberRepository(): MemberRepository {
        return MemoryMemberRepository()
    }

    @Bean
    fun discountPolicy(): DiscountPolicy {
        return FixDiscountPolicy()
    }
}