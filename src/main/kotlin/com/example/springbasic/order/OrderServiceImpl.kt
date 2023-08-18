package com.example.springbasic.order

import com.example.springbasic.discount.DiscountPolicy
import com.example.springbasic.discount.FixDiscountPolicy
import com.example.springbasic.member.MemberRepository
import com.example.springbasic.member.MemoryMemberRepository

class OrderServiceImpl : OrderService {

    private val memberRepository: MemberRepository = MemoryMemberRepository()
    private val discountPolicy: DiscountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}