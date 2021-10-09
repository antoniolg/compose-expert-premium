package com.antonioleiva.marvelcompose.ui.screens.characterdetail

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import com.antonioleiva.marvelcompose.data.entities.Character
import com.antonioleiva.marvelcompose.ui.navigation.ArrowBackIcon

@ExperimentalMaterialApi
@Composable
fun CharacterDetailScaffold(
    character: Character,
    onUpClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(character.name) },
                navigationIcon = { ArrowBackIcon(onUpClick) },
                actions = { AppBarOverflowMenu(character.urls) }

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { shareCharacter(context, character) }
            ) {
                Icon(imageVector = Icons.Default.Share, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = content
    )
}

private fun shareCharacter(context: Context, character: Character) {
    val intent = ShareCompat
        .IntentBuilder(context)
        .setType("text/plain")
        .setSubject(character.name)
        .setText(character.urls.first().url)
        .intent
    context.startActivity(intent)
}