package com.valllent.shared.logic.network.responses

import com.valllent.shared.logic.domain.data.DetailArtwork
import com.valllent.shared.logic.network.utils.HtmlRemover
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailArtworkResponse(
    val data: DetailArtworkItem? = null
) {

    @Serializable
    data class DetailArtworkItem(
        @SerialName("id") val id: Long? = null,
        @SerialName("title") val title: String? = null,
        @SerialName("description") val description: String? = null,
        @SerialName("image_id") val imageId: String? = null,
        @SerialName("date_display") val date: String? = null,
        @SerialName("department_title") val department: String? = null,
        @SerialName("artist_display") val artistInfo: String? = null,
        @SerialName("medium_display") val materialsInfo: String? = null,
        @SerialName("dimensions") val dimensions: String? = null,
        @SerialName("provenance_text") val ownersHistory: String? = null,
    )

    fun convert(): DetailArtwork? {
        val item = data ?: return null

        val descriptionWithoutTags = HtmlRemover.removeHtml(item.description ?: "")
        return DetailArtwork(
            id = item.id ?: return null,
            title = item.title ?: "",
            description = descriptionWithoutTags,
            imageUrl = if (item.imageId != null) "https://www.artic.edu/iiif/2/${item.imageId}/full/843,/0/default.jpg" else null,
            date = item.date ?: "",
            department = item.department ?: "",
            artistInfo = item.artistInfo ?: "",
            materialsInfo = item.materialsInfo ?: "",
            dimensions = item.dimensions ?: "",
            ownersHistory = item.ownersHistory ?: "",
        )
    }

}
