package com.valllent.shared.ui.screens.artworkslist

import com.valllent.shared.logic.domain.data.Artwork

data class ArtworksListState(
    val artworks: List<Artwork>,
    val loading: Boolean,
    val loadingFailed: Boolean,
)