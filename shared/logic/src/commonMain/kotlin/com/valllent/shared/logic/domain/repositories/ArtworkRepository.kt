package com.valllent.shared.logic.domain.repositories

import com.valllent.shared.logic.domain.data.Artwork

interface ArtworkRepository {

    suspend fun getArtworks(): List<Artwork>

}