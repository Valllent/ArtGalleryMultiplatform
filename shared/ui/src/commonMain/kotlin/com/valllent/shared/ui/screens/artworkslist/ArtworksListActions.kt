package com.valllent.shared.ui.screens.artworkslist

data class ArtworksListActions(
    val onArtworkClick: () -> Unit,
    val onRetryClick: () -> Unit,
    val onScrollToEnd: () -> Unit,
)