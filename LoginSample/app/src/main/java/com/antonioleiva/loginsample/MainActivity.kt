package com.antonioleiva.loginsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Up
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonioleiva.loginsample.ui.theme.LoginSampleTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login()
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun Login() {
    Screen {
        var user by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }
        var count by remember { mutableStateOf(0) }
        var passVisible by remember { mutableStateOf(false) }

        val loginEnabled = user.isNotEmpty() && pass.isNotEmpty()

        val infiniteTransition = rememberInfiniteTransition()
        val bgColor by infiniteTransition.animateColor(
            initialValue = Color.White,
            targetValue = Color.LightGray,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = 500
                },
                repeatMode = RepeatMode.Reverse
            )
        )

        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                modifier = Modifier
                    .wrapContentSize()
                    .background(bgColor)
                    .padding(16.dp)
            ) {
                TextField(
                    value = user,
                    onValueChange = { user = it },
                    label = { Text("User") },
                    placeholder = { Text("Use your best email") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )
                TextField(
                    value = pass,
                    onValueChange = { pass = it },
                    label = { Text("Pass") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = if (passVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconToggleButton(
                            checked = passVisible,
                            onCheckedChange = { passVisible = it }) {
                            Crossfade(targetState = passVisible) { visible ->
                                if (visible) {
                                    Icon(
                                        imageVector = Icons.Default.VisibilityOff,
                                        contentDescription = null
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Default.Visibility,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }
                )

                AnimatedContent(
                    targetState = count,
                    transitionSpec = {
                        (slideIntoContainer(Up) + fadeIn() with
                                slideOutOfContainer(Up) + fadeOut())
                    }
                ) {
                    Text(text = "Num of clicks: $it")
                }

                AnimatedVisibility(visible = loginEnabled) {
                    Button(
                        onClick = {
                            count++
                        }
                    ) {
                        Text(text = "LOGIN")
                    }
                }
            }
        }

    }
}

fun validateLogin(user: String, pass: String): String = when {
    !user.contains('@') -> "User must be a valid email"
    pass.length < 5 -> "Password must have at least 5 characters"
    else -> ""
}

@Composable
fun Screen(content: @Composable () -> Unit) {
    LoginSampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
            content = content
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginSampleTheme {
        Greeting("Android")
    }
}