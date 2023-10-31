package com.valllent.shared.logic.domain.usecases

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.domain.data.ResultWrapper
import com.valllent.shared.logic.domain.repositories.ArtworkRepository

class GetArtworksUseCase(
    private val artworkRepository: ArtworkRepository
) {

    suspend operator fun invoke(): ResultWrapper<List<Artwork>> {
        return artworkRepository.getArtworks()
    }

}