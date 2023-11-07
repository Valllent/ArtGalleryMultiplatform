package com.valllent.shared.ui.screens.detailartwork

import com.valllent.shared.logic.domain.usecases.GetDetailArtworkUseCase
import com.valllent.shared.ui.screens.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailArtworkViewModel(
    private val artworkId: Int,
    private val getDetailArtworkUseCase: GetDetailArtworkUseCase
) : BaseViewModel() {

    private val _state = MutableStateFlow<DetailArtworkState>(DetailArtworkState.Loading)
    val state = _state.asStateFlow()

    init {
        loadArtwork()
    }

    fun retry() {
        loadArtwork()
    }

    private fun loadArtwork() {
        getScope().launch {
            _state.value = DetailArtworkState.Loading
            val detailArtwork = getDetailArtworkUseCase(artworkId).resultOrNull()

            if (detailArtwork == null) {
                _state.value = DetailArtworkState.LoadingFailed
                return@launch
            }

            _state.value = DetailArtworkState.Loaded(detailArtwork)
        }
    }

}