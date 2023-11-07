package com.valllent.shared.logic.network.repositories

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.domain.data.DetailArtwork
import com.valllent.shared.logic.domain.data.ResultWrapper
import com.valllent.shared.logic.domain.repositories.ArtworkRepository
import com.valllent.shared.logic.network.api.ArtworkApi

class ArtworkRepositoryImpl(
    private val artworkApi: ArtworkApi
) : ArtworkRepository {

    override suspend fun getArtworks(page: Int): ResultWrapper<List<Artwork>> {
        return ResultWrapper.from {
            artworkApi.getArtworks(page).convert()
        }
    }

    override suspend fun getDetailArtwork(id: Int): ResultWrapper<DetailArtwork> {
        return ResultWrapper.from {
            artworkApi.getDetailArtwork(id).convert()
        }
    }

}