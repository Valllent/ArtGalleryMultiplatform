package com.valllent.shared.logic.network.repositories

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.domain.repositories.ArtworkRepository
import com.valllent.shared.logic.network.api.ArtworkApi

class ArtworkRepositoryImpl(
    private val artworkApi: ArtworkApi
) : ArtworkRepository {

    override suspend fun getArtworks(): List<Artwork> {
        val response = artworkApi.getArtworks()
        return response.convert()
    }

}