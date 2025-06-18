package com.motycka.edu.lesson03.model

/*
 Implement Cuboid class that implements Shape3D interface.
    - It should have a constructor that takes three parameters for width, height, and depth.
    - It should override all methods from Shape3D interface.
 */

class Cuboid(var width: Double, var height: Double, var depth: Double) : Shape3D {
    override fun volume(): Double {
        return width * height * depth
    }

    override fun surfaceArea(): Double {
        return 2 * (width * height + width * depth + height * depth)
    }

}