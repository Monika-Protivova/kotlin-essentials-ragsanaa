package com.motycka.edu.lesson02

val coffeeOrders = mutableMapOf<Int, List<String>>()
var currentOrderId = 0

fun main() {
    // You can write code here to try the functions
    processOrder(listOf(ESPRESSO, CAPPUCCINO, CAPPUCCINO, AMERICANO), 20.0)
    processOrder(listOf(ESPRESSO, FLAT_WHITE, AMERICANO), 10.0)
    // processOrder(listOf(ESPRESSO, ESPRESSO, DOUBLE_ESPRESSO), 5.0) // will fail due to insufficient payment
}

/* Implement the functions below */

fun processOrder(items: List<String>, payment: Double): Double {
    val orderId = placerOrder(items)
    val totalToPay = payOrder(orderId)

    if (totalToPay > payment) {
        error("Insufficient payment. Total to pay is $totalToPay, but received $payment.")
    }
    val change = payment.minus(totalToPay)
    println("Payment successful. Total paid: $payment, Total to pay: $totalToPay, change: $change")

    completeOrder(orderId)

    return change
}

fun placerOrder(items: List<String>): Int {
    coffeeOrders[currentOrderId] = items

    return currentOrderId
}

fun payOrder(orderId: Int): Double {
    val items = if (coffeeOrders[orderId] != null) coffeeOrders[orderId]!! else error("Order ID ${orderId} not found.")
    val prices = items.map { item -> getPrice(item) }

    val discount = if ( items.size > 3) prices.min() else 0.0

    return prices.sum().minus(discount)
}

fun completeOrder(orderId: Int) {
    if (coffeeOrders[orderId] != null)
        coffeeOrders[orderId]!!
    else
        error("Order ID ${orderId} not found.")

    coffeeOrders.remove(orderId)
}

fun getPrice(item: String): Double {
    val price = when (item) {
        ESPRESSO -> ESPRESSO_PRICE
        CAPPUCCINO -> CAPPUCCINO_PRICE
        DOUBLE_ESPRESSO -> DOUBLE_ESPRESSO_PRICE
        FLAT_WHITE -> FLAT_WHITE_PRICE
        LATTE -> LATTE_PRICE
        AMERICANO -> AMERICANO_PRICE
        else -> error("$item is not on the menu!")
    }

    return price
}

