package com.valllent.shared.logic.network.api

import com.valllent.shared.logic.network.responses.ArtworkResponse
import com.valllent.shared.logic.network.responses.DetailArtworkResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ArtworkApi(
    private val client: HttpClient
) {

    /**
     * [Fast browsing](https://api.artic.edu/api/v1/artworks/search?fields=id,title,image_id,description&limit=10&page=1)
     */
    suspend fun getArtworks(page: Int): ArtworkResponse {
        return client
            .get("/api/v1/artworks/search") {
                parameter("fields", "id,title,image_id,description")
                parameter("limit", 10)
                parameter("page", page)
            }
            .body()
    }

    /**
     * [Fast browsing](https://api.artic.edu/api/v1/artworks/129884?fields=id,title,description,image_id,date_display,artwork_type_title,department_title,artist_title,artist_display,medium_display,dimensions,provenance_text)
     */
    suspend fun getDetailArtwork(id: Int): DetailArtworkResponse {
        return client
            .get("/api/v1/artworks/$id") {
                parameter(
                    "fields",
                    "id,title,description,image_id,date_display,artwork_type_title,department_title,artist_title,artist_display,medium_display,dimensions,provenance_text"
                )
            }
            .body()
    }

}