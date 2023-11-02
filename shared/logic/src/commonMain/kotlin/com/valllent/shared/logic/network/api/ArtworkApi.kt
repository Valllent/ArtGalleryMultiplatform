package com.valllent.shared.logic.network.api

import com.valllent.shared.logic.network.responses.ArtworkResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ArtworkApi(
    private val client: HttpClient
) {

    suspend fun getArtworks(page: Int): ArtworkResponse {
        return client
            .get("/api/v1/artworks/search") {
                parameter("fields", "id,title,image_id,description")
                parameter("limit", 10)
                parameter("page", page)
            }
            .body()
    }

}