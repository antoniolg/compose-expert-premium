package com.antonioleiva.marvelcompose.ui.theme

import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.antonioleiva.marvelcompose.R

val GrandStander = FontFamily(
    Font(R.font.grandstander_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.grandstander_blackitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.grandstander_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.grandstander_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.grandstander_extrabold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.grandstander_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.grandstander_extralight, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.grandstander_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.grandstander_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.grandstander_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.grandstander_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.grandstander_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.grandstander_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.grandstander_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.grandstander_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.grandstander_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.grandstander_thin, FontWeight.Thin, FontStyle.Normal),
    Font(R.font.grandstander_thinitalic, FontWeight.Thin, FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = GrandStander,
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)