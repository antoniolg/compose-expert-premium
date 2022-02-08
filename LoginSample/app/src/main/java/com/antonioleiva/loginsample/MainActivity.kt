package com.antonioleiva.loginsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Up
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

        val loginEnabled = user.isNotEmpty() && pass.isNotEmpty()

        val borderDp by animateDpAsState(count.dp)

        Box(
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                modifier = Modifier
                    .wrapContentSize()
                    .background(Color.LightGray)
                    .border(borderDp, Color.Gray)
                    .padding(16.dp)
            ) {
                UserTextField(
                    value = user,
                    onValueChange = { user = it }
                )
                PassTextField(
                    value = pass,
                    onValueChange = { pass = it }
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