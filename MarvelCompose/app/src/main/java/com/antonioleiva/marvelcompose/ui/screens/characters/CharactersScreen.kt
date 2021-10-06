package com.antonioleiva.marvelcompose.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.antonioleiva.marvelcompose.data.CharactersRepository
import com.antonioleiva.marvelcompose.data.entities.Character

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun CharactersScreen() {
    var charactersState by remember { mutableStateOf(emptyList<Character>()) }
    LaunchedEffect(Unit) {
        val charactersRepository = CharactersRepository()
        charactersState = charactersRepository.getCharacters()
    }
    CharactersScreen(charactersState)
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun CharactersScreen(characters: List<Character>) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(180.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(characters) {
            CharacterItem(it)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CharacterItem(character: Character) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Card {
            Image(
                painter = rememberImagePainter(data = character.thumbnail),
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .aspectRatio(1f)
            )
        }
        Box(
            modifier = Modifier.padding(8.dp, 16.dp)
        ) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2
            )
        }
    }
}