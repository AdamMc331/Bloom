package com.adammcneilly.bloom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * The [HomeViewModel] takes in a [plantRepository] to request data, massages that data
 * into a [HomeViewState] that can be exposed by the [viewState] flow in order for the
 * view to render the relevant information.
 */
class HomeViewModel(
    private val plantRepository: PlantRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState: StateFlow<HomeViewState> = _viewState

    init {
        fetchPlantThemes()
        fetchHomeGardenItems()
    }

    private fun fetchPlantThemes() {
        viewModelScope.launch {
            val plantThemes = plantRepository.fetchThemes()

            _viewState.value = _viewState.value.copy(
                plantThemes = plantThemes,
            )
        }
    }

    private fun fetchHomeGardenItems() {
        viewModelScope.launch {
            val homeGardenItems = plantRepository.fetchHomeGardenItems()

            _viewState.value = _viewState.value.copy(
                homeGardenItems = homeGardenItems,
            )
        }
    }
}
