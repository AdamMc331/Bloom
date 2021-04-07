package com.adammcneilly.bloom

class InMemoryPlantService : PlantRepository {
    override suspend fun fetchThemes(): List<PlantTheme> {
        return defaultPlantThemes
    }

    override suspend fun fetchHomeGardenItems(): List<PlantTheme> {
        return homeGardenItems
    }
}
