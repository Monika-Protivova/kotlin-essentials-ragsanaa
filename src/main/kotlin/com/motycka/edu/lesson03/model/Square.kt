package com.motycka.edu.lesson03.model

/*
 Implement Square class that extends the Rectangle class.

    - It should have a constructor that takes one parameter for the side length.
    - It should override all methods from Rectangle class.
    - It should have a method to convert it to a 3D Cuboid with the same side length for width, height, and depth.-
 */

class Square(var side: Double) : Rectangle(side, side) {
    fun to3D(): Shape3D {
        return Cuboid(side, side, side)
    }

    override fun area(): Double {
        return super.area()
    }

    override fun perimeter(): Double {
        return super.perimeter()
    }
}