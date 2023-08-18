package com.example.springbasic.order

data class Order(
    val memberId: Long,
    val itemName: String,
    private val itemPrice: Int,
    private val discountPrice: Int,
) {

    fun calculatePrice(): Int {
        return itemPrice - discountPrice
    }
}