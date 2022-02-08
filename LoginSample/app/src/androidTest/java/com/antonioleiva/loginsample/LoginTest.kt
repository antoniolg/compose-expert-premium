package com.antonioleiva.loginsample

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalAnimationApi
class LoginTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            Login()
        }
    }

    @Test
    fun onlyUserFilledWontShowLoginButton(): Unit = with(composeTestRule) {
        onNodeWithText("User").performTextInput("user")

        onNodeWithText("LOGIN").assertDoesNotExist()
    }

    @Test
    fun userAndPassFilledShowsLoginButton(): Unit = with(composeTestRule) {
        onNodeWithText("User").performTextInput("user")
        onNodeWithText("Pass").performTextInput("pass")

        onNodeWithText("LOGIN").assertExists()
    }
}