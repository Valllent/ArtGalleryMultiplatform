package com.valllent.shared.logic.domain.repositories

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.domain.data.DetailArtwork
import com.valllent.shared.logic.domain.data.ResultWrapper

interface ArtworkRepository {

    suspend fun getArtworks(page: Int): ResultWrapper<List<Artwork>>

    suspend fun getDetailArtwork(id: Int): ResultWrapper<DetailArtwork>

    suspend fun searchArtworks(query: String, page: Int): ResultWrapper<List<Artwork>>

}
