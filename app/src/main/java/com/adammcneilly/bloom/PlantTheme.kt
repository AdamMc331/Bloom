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

val homeGardenItems = listOf(
    PlantTheme(R.drawable.monstera, "Monstera"),
    PlantTheme(R.drawable.aglaonema, "Aglaonema"),
    PlantTheme(R.drawable.peace_lily, "Peace lily"),
    PlantTheme(R.drawable.fiddle_leaf, "Fiddle leaf tree"),
    PlantTheme(R.drawable.snake_plant, "Snake plant"),
    PlantTheme(R.drawable.pothos, "Pothos"),
)
