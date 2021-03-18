package com.adammcneilly.bloom

data class PlantTheme(
    val imageRes: Int,
    val title: String,
)

val defaultPlantThemes = listOf(
    PlantTheme(R.drawable.desert_chic, "Desert chic"),
    PlantTheme(R.drawable.tiny_terrariums, "Tiny terrariums"),
    PlantTheme(R.drawable.jungle_vibes, "Jungle vibes"),
    PlantTheme(R.drawable.easy_care, "Easy care"),
    PlantTheme(R.drawable.statements, "Statements")
)
