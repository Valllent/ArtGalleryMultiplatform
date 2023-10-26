package com.valllent.shared.logic.network.api

import com.valllent.shared.logic.network.responses.ArtworkResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArtworkApi(
    private val client: HttpClient
) {

    public suspend fun getArtworks(): ArtworkResponse {
        return client
            .get("https://api.artic.edu/api/v1/artworks")
            .body()
    }

}