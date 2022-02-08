package com.antonioleiva.loginsample

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

const val PASS_TEXT_FIELD_TEST_TAG = "PassTextFieldTestTag"
const val PASS_REVEAL_ICON_TEST_TAG = "PassRevealIconTestTag"

@Composable
fun PassTextField(value: String, onValueChange: (String) -> Unit) {
    var passVisible by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Pass") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconToggleButton(
                checked = passVisible,
                onCheckedChange = { passVisible = it },
                modifier = Modifier.testTag(PASS_REVEAL_ICON_TEST_TAG)
            ) {
                Crossfade(targetState = passVisible) { visible ->
                    if (visible) {
                        Icon(
                            imageVector = Icons.Default.VisibilityOff,
                            contentDescription = stringResource(id = R.string.hide_password)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = stringResource(id = R.string.reveal_password)
                        )
                    }
                }
            }
        },
        modifier = Modifier.testTag(PASS_TEXT_FIELD_TEST_TAG)
    )
}