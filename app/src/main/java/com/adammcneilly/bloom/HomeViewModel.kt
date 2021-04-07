package com.adammcneilly.bloom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val plantRepository: PlantRepository,
) : ViewModel() {
    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState: StateFlow<HomeViewState> = _viewState

    init {
        fetchThemes()
        fetchGardenItems()
    }

    private fun fetchThemes() {
        viewModelScope.launch {
            val themes = plantRepository.fetchThemes()
            _viewState.value = _viewState.value.copy(
                themes = themes,
            )
        }
    }

    private fun fetchGardenItems() {
        viewModelScope.launch {
            val gardenItems = plantRepository.fetchGardenItems()
            _viewState.value = _viewState.value.copy(
                gardenItems = gardenItems,
            )
        }
    }
}
