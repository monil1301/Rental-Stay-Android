package com.shah.android.app.rentalstay.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = StromboliGreen,
    primaryVariant = GoblinGreen,
    onPrimary = Color.White,
    surface = EclipseGray,
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = MediumAquamarineGreen,
    primaryVariant = MountainMeadowGreen,
    onPrimary = Color.White,
    surface = SnowWhite,
    onSurface = Color.Black
)

@Composable
fun RentalStayTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}
