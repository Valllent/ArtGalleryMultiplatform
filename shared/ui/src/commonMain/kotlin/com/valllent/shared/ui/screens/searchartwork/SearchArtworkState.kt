package com.valllent.shared.ui.screens.searchartwork

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.pagination.PagerList

data class SearchArtworkState(
    val searchQuery: String,
    val lastSentSearchQuery: String,
    val artworksPagerList: PagerList<Artwork>?
)