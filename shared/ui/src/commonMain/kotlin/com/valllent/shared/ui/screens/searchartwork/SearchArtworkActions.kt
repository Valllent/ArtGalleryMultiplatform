package com.valllent.shared.ui.screens.searchartwork

import com.valllent.shared.logic.domain.data.Artwork

data class SearchArtworkActions(
    val onClickBack: () -> Unit,
    val onSearchRequestChange: (String) -> Unit,
    val onSearchClick: () -> Unit,
    val onScrollToEnd: () -> Unit,
    val onRetryClick: () -> Unit,
    val onArtworkClick: (Artwork) -> Unit,
)