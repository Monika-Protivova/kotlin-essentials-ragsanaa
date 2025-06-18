package com.motycka.edu.lesson04

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe

// By convention, the name of the test class should be the name of the class under test + "Test"
class TemperatureConverterTest : StringSpec({
    "convert Fahrenheit to Celsius where fahrenheit is 32" {
        val fahrenheit = 32.0

        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        celsius shouldBe 0.0
    }

    "convert Fahrenheit to Celsius where fahrenheit is 212" {
        val fahrenheit = 212.0

        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        celsius shouldBe 100.0
    }

    "convert Fahrenheit to Celsius where fahrenheit is 98.6" {
        val fahrenheit = 98.6

        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        celsius shouldBe 37.0
    }

    "convert Fahrenheit to Celsius where fahrenheit is -40" {
        val fahrenheit = -40.0

        val celsius = TemperatureConverter.toCelsius(fahrenheit)

        celsius shouldBe -40.0
    }

    "convert Celsius to Fahrenheit where celsius is 0" {
        val celsius = 0.0

        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)

        fahrenheit shouldBe 32.0
    }

    "convert Celsius to Fahrenheit where celsius is 37" {
        val celsius = 37.0

        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)

        fahrenheit shouldBe 98.6
    }

    "convert Celsius to Fahrenheit where celsius is 100" {
        val celsius = 100.0

        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)

        fahrenheit shouldBe 212.0
    }

    // Very large temperature value
    "convert very large Celsius to Fahrenheit" {
        val celsius = 1_000_000.0
        val fahrenheit = TemperatureConverter.toFahrenheit(celsius)
        fahrenheit shouldBe 1_800_032.0
    }

    // Very small (negative) temperature value
    "convert very small Fahrenheit to Celsius" {
        val fahrenheit = -1_000_000.0
        val celsius = TemperatureConverter.toCelsius(fahrenheit)
        celsius shouldBe -555_573.3333333334
    }

    // Round-trip: Celsius → Fahrenheit → Celsius
    "round-trip conversion from Celsius to Fahrenheit to Celsius" {
        val originalCelsius = 100.0
        val fahrenheit = TemperatureConverter.toFahrenheit(originalCelsius)
        val convertedCelsius = TemperatureConverter.toCelsius(fahrenheit)
        convertedCelsius shouldBeExactly originalCelsius
    }

    // Round-trip: Fahrenheit → Celsius → Fahrenheit
    "round-trip conversion from Fahrenheit to Celsius to Fahrenheit" {
        val originalFahrenheit = 451.0
        val celsius = TemperatureConverter.toCelsius(originalFahrenheit)
        val convertedFahrenheit = TemperatureConverter.toFahrenheit(celsius)
        convertedFahrenheit shouldBe originalFahrenheit
    }
})
