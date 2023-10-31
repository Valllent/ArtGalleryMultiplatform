package com.valllent.shared.logic.domain.repositories

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.domain.data.ResultWrapper

interface ArtworkRepository {

    suspend fun getArtworks(): ResultWrapper<List<Artwork>>

}