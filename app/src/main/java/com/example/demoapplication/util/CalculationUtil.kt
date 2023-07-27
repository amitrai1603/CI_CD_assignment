package com.example.demoapplication.util

import kotlin.math.abs

/**
 * Util class for getting the result after performing the mathematical operation.
 */
class CalculationUtil {

    /**
     * Method to get the sum of two numbers.
     *
     * @param number1 First number.
     * @param number2 Second number.
     * @return Result string with sum of first and second number.
     */
    fun getSumOfTwoNumber(number1: Int, number2: Int): String {
        return "The sum of two numbers is ${number1 + number2}"
    }

    /**
     * Method to get the difference of two numbers.
     *
     * @param number1 First number.
     * @param number2 Second number.
     * @return Result string with difference of first and second number.
     */
    fun getDifferenceOfTwoNumber(number1: Int, number2: Int): String {
        return "The difference of two numbers is ${abs( number1 - number2)}"
    }

    /**
     * Method to get the multiple of two numbers.
     *
     * @param number1 First number.
     * @param number2 Second number.
     * @return Result string with multiple of first and second number.
     */
    fun getMultipleOfTwoNumber(number1: Int, number2: Int): String {
        return "The multiple of two numbers is ${number1 * number2}"
    }
}