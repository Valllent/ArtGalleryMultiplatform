package com.valllent.shared.ui.screens.detailartwork

import com.valllent.shared.logic.domain.data.DetailArtwork

sealed class DetailArtworkState {

    data class Loaded(
        val detailArtwork: DetailArtwork
    ) : DetailArtworkState()

    data object Loading : DetailArtworkState()

    data object LoadingFailed : DetailArtworkState()

}