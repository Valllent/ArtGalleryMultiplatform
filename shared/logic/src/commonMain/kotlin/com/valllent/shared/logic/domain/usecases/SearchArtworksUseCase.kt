package com.valllent.shared.logic.domain.usecases

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.domain.data.ResultWrapper
import com.valllent.shared.logic.domain.repositories.ArtworkRepository

class SearchArtworksUseCase(
    private val artworkRepository: ArtworkRepository
) {

    suspend operator fun invoke(query: String, page: Int): ResultWrapper<List<Artwork>> {
        return artworkRepository.searchArtworks(query, page)
    }

}