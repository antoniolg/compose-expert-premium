package com.antonioleiva.marvelcompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.antonioleiva.marvelcompose.data.entities.Comic
import com.antonioleiva.marvelcompose.data.repositories.ComicsRepository
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemDetailScreen
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemsList
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ComicsScreen(onClick: (Comic) -> Unit) {

    var comicsState by remember() { mutableStateOf(emptyList<Comic>()) }
    LaunchedEffect(Unit) {
        comicsState = ComicsRepository.get()
    }

    val formats = Comic.Format.values().toList()
    val pagerState = rememberPagerState()

    Column {
        ComicFormatsTabRow(
            pagerState = pagerState,
            formats = formats
        )
        HorizontalPager(
            count = formats.size,
            state = pagerState
        ) {
            MarvelItemsList(
                items = comicsState,
                onItemClick = onClick
            )
        }
    }

}

@ExperimentalPagerApi
@Composable
private fun ComicFormatsTabRow(
    pagerState: PagerState,
    formats: List<Comic.Format>
) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(
                    pagerState,
                    tabPositions
                )
            )

        }
    ) {
        formats.forEach {
            Tab(
                selected = it.ordinal == pagerState.currentPage,
                onClick = { scope.launch { pagerState.animateScrollToPage(it.ordinal) } },
                text = { Text(text = it.name) }
            )
        }
    }
}


@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun ComicDetailScreen(comicId: Int) {
    var comicState by remember { mutableStateOf<Comic?>(null) }
    LaunchedEffect(Unit) {
        comicState = ComicsRepository.find(comicId)
    }
    comicState?.let {
        MarvelItemDetailScreen(it)
    }
}