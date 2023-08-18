package com.example.springbasic.order

interface OrderService {
    fun createOrder(
        memberId: Long,
        itemName: String,
        itemPrice: Int,
    ): Order
}