package com.example.springbasic.discount

import com.example.springbasic.member.Grade
import com.example.springbasic.member.Member

class RateDiscountPolicy: DiscountPolicy {

    private val discountPercent = 10

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            price * discountPercent / 100
        } else {
            0
        }
    }
}