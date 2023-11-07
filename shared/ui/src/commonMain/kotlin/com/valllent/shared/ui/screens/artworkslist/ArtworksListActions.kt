package com.valllent.shared.ui.screens.artworkslist

import com.valllent.shared.logic.domain.data.Artwork

data class ArtworksListActions(
    val onArtworkClick: (Artwork) -> Unit,
    val onRetryClick: () -> Unit,
    val onScrollToEnd: () -> Unit,
)