package com.antonioleiva.marvelcompose

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.antonioleiva.marvelcompose.ui.theme.MarvelComposeTheme

@Composable
fun MarvelApp(content: @Composable () -> Unit) {
    MarvelComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}