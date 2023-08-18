package com.example.springbasic.discount

import com.example.springbasic.member.Grade
import com.example.springbasic.member.Member

class FixDiscountPolicy: DiscountPolicy {

    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            discountFixAmount
        } else {
            0
        }
    }
}