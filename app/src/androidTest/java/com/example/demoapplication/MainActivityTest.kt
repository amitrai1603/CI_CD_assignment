package com.example.demoapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule(order = 0)
    var composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun mainActivity_assertHomeScreenCorrectlyDisplayed() {
        composeRule.onNodeWithText("CI / CD assignment")
    }

    @Test
    fun mainActivity_assertHomeIconIsCorrectlyDisplayed() {
        composeRule.onNodeWithContentDescription("Home icon").assertIsDisplayed()
    }

    @Test
    fun mainActivity_assertAllButtonIsDisplayed() {
        composeRule.onNodeWithText("Add two numbers").assertIsDisplayed()
        composeRule.onNodeWithText("Difference of two numbers").assertIsDisplayed()
        composeRule.onNodeWithText("Multiply two numbers").assertIsDisplayed()
    }

    @Test
    fun mainActivity_OnEnteringNumbersAndClickingAddTwoNumbers_correctResultIsShown() {
        composeRule.onNodeWithText("First number").performTextInput(FIRST_NUMBER)
        composeRule.onNodeWithText("Second number").performTextInput(SECOND_NUMBER)

        composeRule.onNodeWithText("Add two numbers").performClick()
        val stringExpectedResult =
            "The sum of two numbers is ${FIRST_NUMBER.toInt() + SECOND_NUMBER.toInt()}"

        composeRule.onNodeWithText(stringExpectedResult).assertIsDisplayed()
    }

    @Test
    fun mainActivity_OnEnteringNumbersAndClickingDifferenceOfTwoNumbers_correctResultIsShown() {
        composeRule.onNodeWithText("First number").performTextInput(FIRST_NUMBER)
        composeRule.onNodeWithText("Second number").performTextInput(SECOND_NUMBER)

        composeRule.onNodeWithText("Difference of two numbers").performClick()
        val stringExpectedResult =
            "The difference of two numbers is ${FIRST_NUMBER.toInt() - SECOND_NUMBER.toInt()}"

        composeRule.onNodeWithText(stringExpectedResult).assertIsDisplayed()
    }

    @Test
    fun mainActivity_OnEnteringNumbersAndClickingMultiplyTwoNumbers_correctResultIsShown() {
        composeRule.onNodeWithText("First number").performTextInput(FIRST_NUMBER)
        composeRule.onNodeWithText("Second number").performTextInput(SECOND_NUMBER)

        composeRule.onNodeWithText("Multiply two numbers").performClick()
        val stringExpectedResult =
            "The multiple of two numbers is ${FIRST_NUMBER.toInt() * SECOND_NUMBER.toInt()}"

        composeRule.onNodeWithText(stringExpectedResult).assertIsDisplayed()
    }

    companion object {
        private const val FIRST_NUMBER = "15"
        private const val SECOND_NUMBER = "10"
    }
}
