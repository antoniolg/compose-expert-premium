package com.antonioleiva.mymovies.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.antonioleiva.domain.Movie

@ExperimentalCoilApi
@Composable
fun MovieViewItem(movie: Movie, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(2.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant
    ) {
        Column {
            Image(
                painter = rememberImagePainter("https://image.tmdb.org/t/p/w185/${movie.posterPath}"),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1 / 1.5f)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(8.dp, 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = movie.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1
                )
            }

        }
    }
}