package com.antonioleiva.marvelcompose.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.antonioleiva.marvelcompose.data.entities.Character

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
    Surface(
        modifier = Modifier.padding(8.dp)
    ) {
        Column {
            Image(
                painter = rememberImagePainter(data = character.thumbnail),
                contentDescription = character.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
                    .aspectRatio(1 / 1.5f)
            )
            Box(
                modifier = Modifier.padding(8.dp, 16.dp)
            ) {
                Text(character.name)
            }
        }
    }
}
