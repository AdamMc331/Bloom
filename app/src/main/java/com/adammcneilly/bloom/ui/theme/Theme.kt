package com.adammcneilly.bloom.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Green900,
    secondary = Green300,
    background = Gray,
    surface = White150,
    onPrimary = White,
    onSecondary = Gray,
    onBackground = White,
    onSurface = White850,
)

private val LightColorPalette = lightColors(
    primary = Pink100,
    secondary = Pink900,
    background = White,
    surface = White850,
    onPrimary = Gray,
    onSecondary = White,
    onBackground = Gray,
    onSurface = Gray,
)

@Composable
fun BloomTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}