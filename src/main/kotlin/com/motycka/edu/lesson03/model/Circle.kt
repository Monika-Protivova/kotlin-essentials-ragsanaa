package com.motycka.edu.lesson03.model

import kotlin.math.PI

/*
 Implement Circle class that implements Shape2D and Ellipse interfaces.

    - It should have a constructor that takes one parameter for the radius.
    - It should override all methods from Shape2D and Ellipse interfaces.
 */

class Circle(override val radius: Double) : Ellipse, Shape2D{
    override fun to3D(): Shape3D {
        val sphere = Sphere(radius)
        return sphere
    }

    override fun area(): Double {
        return radius * radius * PI
    }

    override fun perimeter(): Double {
        return 2 * PI * radius
    }

}
