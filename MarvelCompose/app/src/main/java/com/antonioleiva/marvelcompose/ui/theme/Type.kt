package com.antonioleiva.marvelcompose.ui.theme

import androidx.compose.material3.Typography
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
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
).defaultFontFamily(GrandStander)

fun Typography.defaultFontFamily(fontFamily: FontFamily) = this.copy(
    displayLarge = this.displayLarge.copy(fontFamily = fontFamily),
    displayMedium = this.displayMedium.copy(fontFamily = fontFamily),
    displaySmall = this.displaySmall.copy(fontFamily = fontFamily),
    headlineLarge = this.headlineLarge.copy(fontFamily = fontFamily),
    headlineMedium = this.headlineMedium.copy(fontFamily = fontFamily),
    headlineSmall = this.headlineSmall.copy(fontFamily = fontFamily),
    titleLarge = this.titleLarge.copy(fontFamily = fontFamily),
    titleMedium = this.titleMedium.copy(fontFamily = fontFamily),
    titleSmall = this.titleSmall.copy(fontFamily = fontFamily),
    bodyLarge = this.bodyLarge.copy(fontFamily = fontFamily),
    bodyMedium = this.bodyMedium.copy(fontFamily = fontFamily),
    bodySmall = this.bodySmall.copy(fontFamily = fontFamily),
    labelLarge = this.labelLarge.copy(fontFamily = fontFamily),
    labelMedium = this.labelMedium.copy(fontFamily = fontFamily),
    labelSmall = this.labelSmall.copy(fontFamily = fontFamily),
)