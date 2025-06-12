package com.motycka.edu.lesson02

/*
Define String variables for two types of coffee: espresso and cappuccino.
 */
const val espresso = "Espresso"
const val cappuccino = "Cappuccino"

/*
Define Double variables for the prices of espresso and cappuccino.
 */
const val espressoPrice: Double = 2.5
const val cappuccinoPrice: Double = 3.0

fun variables(espressoQuantity: Int, cappuccinoQuantity: Int) {

    val totalPrice: Double =( espressoQuantity * espressoPrice) + (cappuccinoQuantity * cappuccinoPrice)

    println(totalPrice)
}


fun main(args: Array<String>) {

    val espressoQuantity = args.count { it.lowercase() == espresso.lowercase() }
    val cappuccinoQuantity = args.count { it.lowercase() == cappuccino.lowercase() }

    variables(espressoQuantity = espressoQuantity, cappuccinoQuantity = cappuccinoQuantity)
}
