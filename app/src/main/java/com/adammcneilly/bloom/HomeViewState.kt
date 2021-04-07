package com.adammcneilly.bloom

data class HomeViewState(
    val themes: List<PlantTheme> = emptyList(),
    val gardenItems: List<PlantTheme> = emptyList(),
)
