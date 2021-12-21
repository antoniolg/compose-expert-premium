package com.antonioleiva.marvelcompose.ui.navigation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonioleiva.marvelcompose.ui.MarvelScreen

@ExperimentalMaterialApi
@Composable
fun DrawerContent(
    drawerOptions: List<NavItem>,
    selectedIndex: Int,
    onOptionClick: (NavItem) -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colors.primaryVariant,
                        MaterialTheme.colors.secondary
                    )
                )
            )
            .height(200.dp)
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    drawerOptions.forEachIndexed { index, navItem ->
        val selected = selectedIndex == index
        val colors = MaterialTheme.colors

        val localContentColor = if (selected) colors.primary else colors.onBackground

        CompositionLocalProvider(
            LocalContentColor provides localContentColor,
            LocalTextStyle provides MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
        ) {
            Row(
                modifier = Modifier
                    .clickable { onOptionClick(navItem) }
                    .fillMaxWidth()
                    .padding(8.dp, 4.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(color = if (selected) LocalContentColor.current.copy(alpha = 0.12f) else Color.Transparent)
                    .padding(12.dp)
            ) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = stringResource(id = navItem.title),
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DrawerContentPreview() {
    MarvelScreen {
        Column {
            DrawerContent(
                drawerOptions = listOf(NavItem.HOME, NavItem.SETTINGS),
                selectedIndex = 0,
                onOptionClick = {}
            )
        }

    }
}