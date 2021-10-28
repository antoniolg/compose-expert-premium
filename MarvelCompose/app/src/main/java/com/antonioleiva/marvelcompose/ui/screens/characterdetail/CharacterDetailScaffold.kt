package com.antonioleiva.marvelcompose.ui.screens.characterdetail

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import com.antonioleiva.marvelcompose.data.entities.MarvelItem
import com.antonioleiva.marvelcompose.data.entities.Url
import com.antonioleiva.marvelcompose.ui.navigation.AppBarIcon
import com.antonioleiva.marvelcompose.ui.navigation.ArrowBackIcon

@ExperimentalMaterialApi
@Composable
fun MarvelItemDetailScaffold(
    marvelItem: MarvelItem,
    onUpClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(marvelItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) },
                actions = { AppBarOverflowMenu(marvelItem.urls) }

            )
        },
        floatingActionButton = {
            if (marvelItem.urls.isNotEmpty()) {
                FloatingActionButton(
                    onClick = { shareCharacter(context, marvelItem.title, marvelItem.urls.first()) }
                ) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = null)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape
            ) {
                AppBarIcon(imageVector = Icons.Default.Menu, onClick = { })
                Spacer(modifier = Modifier.weight(1f))
                AppBarIcon(imageVector = Icons.Default.Favorite, onClick = { })
            }
        },
        content = content
    )
}

private fun shareCharacter(context: Context, name: String, url: Url) {
    val intent = ShareCompat
        .IntentBuilder(context)
        .setType("text/plain")
        .setSubject(name)
        .setText(url.destination)
        .intent
    context.startActivity(intent)
}