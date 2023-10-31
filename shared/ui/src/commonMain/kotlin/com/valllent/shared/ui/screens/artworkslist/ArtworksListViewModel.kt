package com.valllent.shared.ui.screens.artworkslist

import com.valllent.shared.logic.domain.usecases.GetArtworksUseCase
import com.valllent.shared.ui.screens.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArtworksListViewModel(
    private val getArtworksUseCase: GetArtworksUseCase
) : BaseViewModel() {

    private val _state = MutableStateFlow(
        ArtworksListState(
            artworks = emptyList(),
            loading = true,
            loadingFailed = false
        )
    )
    val state = _state.asStateFlow()

    init {
        getScope().launch {
            getArtworksUseCase().on(
                success = {
                    _state.value = _state.value.copy(
                        artworks = it,
                        loading = false
                    )
                },
                failure = {
                    _state.value = _state.value.copy(
                        loading = false,
                        loadingFailed = true,
                    )
                }
            )
        }
    }

}