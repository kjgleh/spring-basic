package com.example.springbasic

import com.example.springbasic.discount.DiscountPolicy
import com.example.springbasic.discount.FixDiscountPolicy
import com.example.springbasic.member.MemberRepository
import com.example.springbasic.member.MemberService
import com.example.springbasic.member.MemberServiceImpl
import com.example.springbasic.member.MemoryMemberRepository
import com.example.springbasic.order.OrderService
import com.example.springbasic.order.OrderServiceImpl

class AppConfig {

    fun memberService(): MemberService {
        return MemberServiceImpl(
            memberRepository(),
        )
    }

    fun orderService(): OrderService {
        return OrderServiceImpl(
            memberRepository(),
            discountPolicy()
        )
    }

    fun memberRepository(): MemberRepository {
        return MemoryMemberRepository()
    }

    fun discountPolicy(): DiscountPolicy {
        return FixDiscountPolicy()
    }
}