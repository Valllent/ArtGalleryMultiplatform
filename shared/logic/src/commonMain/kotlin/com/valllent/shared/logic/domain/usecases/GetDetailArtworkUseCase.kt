package com.valllent.shared.logic.domain.usecases

import com.valllent.shared.logic.domain.data.DetailArtwork
import com.valllent.shared.logic.domain.data.ResultWrapper
import com.valllent.shared.logic.domain.repositories.ArtworkRepository

class GetDetailArtworkUseCase(
    private val artworkRepository: ArtworkRepository
) {

    suspend operator fun invoke(id: Int): ResultWrapper<DetailArtwork> {
        return artworkRepository.getDetailArtwork(id)
    }

}