package com.adammcneilly.bloom

/**
 * [PlantRepository] serves as the model layer for our home screen. This allows the user to
 * request themes and garden items.
 *
 * We use an interface so that we can create multiple implementations and swap them out.
 */
interface PlantRepository {
    suspend fun fetchThemes(): List<PlantTheme>
    suspend fun fetchHomeGardenItems(): List<PlantTheme>
}
