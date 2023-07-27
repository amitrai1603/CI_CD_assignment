package com.example.demoapplication.util

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalculationUtilTest {
    private lateinit var calculationUtil: CalculationUtil

    @Before
    fun setup() {
        calculationUtil = CalculationUtil()
    }

    @Test
    fun calculationUtil_onClickingAddTwoNumber_returnsCorrectResult() {
        val result: String = calculationUtil.getSumOfTwoNumber(FIRST_NUMBER, SECOND_NUMBER)

        val expectedResult = FIRST_NUMBER + SECOND_NUMBER
        val stringExpectedResult = "The sum of two numbers is $expectedResult"
        Assert.assertEquals(stringExpectedResult, result)
    }

    @Test
    fun calculationUtil_onClickingDifferenceOfTwoNumber_returnsCorrectResult() {
        val result: String = calculationUtil.getDifferenceOfTwoNumber(FIRST_NUMBER, SECOND_NUMBER)

        val expectedResult = (FIRST_NUMBER - SECOND_NUMBER)
        val stringExpectedResult = "The difference of two numbers is $expectedResult"
        Assert.assertEquals(stringExpectedResult, result)
    }

    @Test
    fun calculationUtil_onClickingMultiplyTwoNumber_returnsCorrectResult() {
        val result: String = calculationUtil.getMultipleOfTwoNumber(FIRST_NUMBER, SECOND_NUMBER)

        val expectedResult = FIRST_NUMBER * SECOND_NUMBER
        val stringExpectedResult = "The multiple of two numbers is $expectedResult"
        Assert.assertEquals(stringExpectedResult, result)
    }

    companion object {
        private const val FIRST_NUMBER = 15
        private const val SECOND_NUMBER = 10
    }
}
