package com.valllent.shared.logic.network.responses

import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.logic.network.utils.HtmlRemover
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtworkResponse(
    val data: List<ArtworkItem>? = null
) {

    @Serializable
    data class ArtworkItem(
        val id: Long? = null,
        val title: String? = null,
        val description: String? = null,
        @SerialName("image_id") val imageId: String? = null,
    )

    fun convert(): List<Artwork> {
        val list = data ?: emptyList()
        val result = ArrayList<Artwork>(list.size)

        for (item in list) {
            val id = item.id ?: continue
            val descriptionWithoutHtml = HtmlRemover.removeHtml(item.description ?: "")
            result.add(
                Artwork(
                    id = id,
                    title = item.title ?: "",
                    description = descriptionWithoutHtml,
                    imageUrl = if (item.imageId != null) "https://www.artic.edu/iiif/2/${item.imageId}/full/843,/0/default.jpg" else null
                )
            )
        }

        return result
    }

}
