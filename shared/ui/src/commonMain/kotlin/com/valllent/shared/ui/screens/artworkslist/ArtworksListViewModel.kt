package com.valllent.shared.ui.screens.artworkslist

import com.valllent.shared.logic.domain.usecases.GetArtworksUseCase
import com.valllent.shared.ui.pagination.CustomPager
import com.valllent.shared.ui.screens.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArtworksListViewModel(
    private val getArtworksUseCase: GetArtworksUseCase
) : BaseViewModel() {

    private val pager = CustomPager { page, pagerActions ->
        return@CustomPager getArtworksUseCase(page).resultOrNull()
    }

    private val _state = MutableStateFlow(
        ArtworksListState(
            artworks = pager.state.value
        )
    )
    val state = _state.asStateFlow()

    init {
        scope.launch {
            pager.loadFirstPageIfNotYet()
        }
        scope.launch {
            pager.state.collect {
                _state.value = _state.value.copy(artworks = it)
            }
        }
    }

    fun requestNextPage() {
        scope.launch {
            pager.loadNextPage()
        }
    }

}