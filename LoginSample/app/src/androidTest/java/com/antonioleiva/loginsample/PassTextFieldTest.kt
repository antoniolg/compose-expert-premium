package com.antonioleiva.loginsample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PassTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val ctx = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
        composeTestRule.setContent {
            var state by remember { mutableStateOf("") }
            PassTextField(value = state, onValueChange = { state = it })
        }
    }

    @Test
    fun revealIconShowsPassword(): Unit = with(composeTestRule) {

        onNodeWithText("").performTextInput("pass")
        onNodeWithText("••••")

        onNodeWithContentDescription(ctx.getString(R.string.reveal_password)).performClick()

        onNodeWithText("pass").assertExists()
        onNodeWithContentDescription(ctx.getString(R.string.hide_password)).assertExists()
    }
}