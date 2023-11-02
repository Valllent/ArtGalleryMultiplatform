package com.valllent.shared.ui.screens.artworkslist

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.pagination.PagerList

data class ArtworksListState(
    val artworks: PagerList<Artwork>,
)