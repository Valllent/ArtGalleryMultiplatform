package com.valllent.shared.ui.screens.fastinfodialog

import com.valllent.shared.logic.domain.data.Artwork

object ArtworkCacheUtils {

    private var artwork: Artwork? = null

    fun put(artwork: Artwork) {
        ArtworkCacheUtils.artwork = artwork
    }

    fun get(): Artwork? {
        return artwork
    }

}