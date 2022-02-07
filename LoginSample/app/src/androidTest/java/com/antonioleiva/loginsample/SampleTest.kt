package com.antonioleiva.loginsample

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class SampleTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun sampleTest(): Unit = with(composeTestRule) {
        setContent {
            var text by remember { mutableStateOf("Hello") }
            Button(onClick = { text = "Goodbye" }) {
                Text(text = text)
            }
        }

        onNodeWithText("Hello").performClick()

        onNodeWithText("Goodbye").assertExists()
    }
}