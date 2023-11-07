package com.valllent.shared.logic.domain.data

data class DetailArtwork(
    val id: Long,
    val title: String,
    val description: String,
    val imageUrl: String?,
    val date: String,
    val department: String,
    val artistInfo: String,
    val materialsInfo: String,
    val dimensions: String,
    val ownersHistory: String,
)
