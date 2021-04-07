package com.adammcneilly.bloom

interface PlantRepository {
    suspend fun fetchThemes(): List<PlantTheme>

    suspend fun fetchGardenItems(): List<PlantTheme>
}