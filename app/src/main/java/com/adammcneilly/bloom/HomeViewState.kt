package com.adammcneilly.bloom

/**
 * This data class represents the view state for the home screen. All of this
 * data should be formatted in a way that the home screen can just
 * take the information and display it.
 */
data class HomeViewState(
    val plantThemes: List<PlantTheme> = emptyList(),
    val homeGardenItems: List<PlantTheme> = emptyList(),
)
