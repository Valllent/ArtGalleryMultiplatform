package com.valllent.shared.logic.network.repositories

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.domain.data.ResultWrapper
import com.valllent.shared.logic.domain.repositories.ArtworkRepository
import com.valllent.shared.logic.network.api.ArtworkApi

class ArtworkRepositoryImpl(
    private val artworkApi: ArtworkApi
) : ArtworkRepository {

    override suspend fun getArtworks(): ResultWrapper<List<Artwork>> {
        return runSafely {
            artworkApi.getArtworks().convert()
        }
    }

    private suspend fun <T> runSafely(code: suspend () -> T): ResultWrapper<T> {
        val runner = runCatching { code() }

        val result = runner.getOrNull()
        if (result != null) {
            return ResultWrapper.Success(result)
        }

        val exception = runner.exceptionOrNull()
        return ResultWrapper.Failure("Network error: $exception")
    }

}