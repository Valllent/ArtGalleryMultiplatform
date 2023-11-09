package com.valllent.shared.ui.screens.searchartwork

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.domain.usecases.SearchArtworksUseCase
import com.valllent.shared.ui.pagination.CustomPager
import com.valllent.shared.ui.screens.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchArtworkViewModel(
    private val searchArtworksUseCase: SearchArtworksUseCase
) : BaseViewModel() {

    private val _state = MutableStateFlow(
        SearchArtworkState(
            searchQuery = "",
            lastSentSearchQuery = "",
            artworksPagerList = null,
        )
    )
    val state = _state.asStateFlow()

    private var pager: CustomPager<Artwork>? = null

    fun setSearchRequest(value: String) {
        _state.value = state.value.copy(
            searchQuery = value
        )
    }

    fun search() {
        if (state.value.searchQuery.isBlank()) {
            return
        }

        if (state.value.lastSentSearchQuery == state.value.searchQuery) {
            return
        }

        pager = createPager(state.value.searchQuery)
        _state.value = state.value.copy(
            lastSentSearchQuery = state.value.searchQuery,
            artworksPagerList = pager?.state?.value
        )

        scope.launch {
            pager?.state?.collect {
                _state.value = _state.value.copy(artworksPagerList = it)
            }
        }
        scope.launch {
            pager?.loadFirstPageIfNotYet()
        }
    }

    fun requestNextPage() {
        scope.launch {
            pager?.loadNextPage()
        }
    }

    private fun createPager(searchQuery: String): CustomPager<Artwork> {
        return CustomPager { page, actions ->
            searchArtworksUseCase(searchQuery, page).resultOrNull()
        }
    }

}