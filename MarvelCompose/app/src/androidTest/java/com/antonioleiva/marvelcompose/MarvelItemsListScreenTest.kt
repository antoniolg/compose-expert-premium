package com.antonioleiva.marvelcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import arrow.core.Either
import com.antonioleiva.marvelcompose.data.entities.Comic
import com.antonioleiva.marvelcompose.ui.screens.common.MarvelItemsListScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalFoundationApi
@ExperimentalMaterialApi
class MarvelItemsListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val ctx = InstrumentationRegistry.getInstrumentation().targetContext

    private val items: List<Comic> = (1..100).map {
        Comic(
            id = it,
            title = "Title $it",
            description = "Description $it",
            thumbnail = "",
            format = Comic.Format.COMIC,
            urls = emptyList(),
            references = emptyList()
        )
    }

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MarvelItemsListScreen(items = Either.Right(items), onClick = {})
        }
    }

    @Test
    fun navigatesTo51(): Unit = with(composeTestRule) {
        onNode(hasScrollToIndexAction()).performScrollToIndex(25)
        onNodeWithText("Title 51").assertExists()
    }

    @Test
    fun navigatesTo51AndShowsBottomSheet(): Unit = with(composeTestRule) {
        onNode(hasScrollToIndexAction()).performScrollToIndex(25)
        onNode(
            hasParent(hasText("Title 51")) and
                    hasContentDescription(ctx.getString(R.string.more_options))
        ).performClick()

        onNode(
            hasAnySibling(hasText(ctx.getString(R.string.go_to_detail))) and
                    hasText("Title 51")
        ).assertExists()
    }
}