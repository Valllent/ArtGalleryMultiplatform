package com.valllent.shared.logic.network.responses

import com.valllent.shared.logic.domain.data.Artwork
import kotlinx.serialization.Serializable

@Serializable
data class ArtworkResponse(
    val data: List<ArtworkItem>? = null
) {

    @Serializable
    data class ArtworkItem(
        val id: Long? = null,
        val title: String? = null,
    )

    fun convert(): List<Artwork> {
        val list = data ?: emptyList()
        val result = ArrayList<Artwork>(list.size)

        for (item in list) {
            val id = item.id ?: continue
            result.add(
                Artwork(
                    id = id,
                    title = item.title ?: ""
                )
            )
        }

        return result
    }

}
