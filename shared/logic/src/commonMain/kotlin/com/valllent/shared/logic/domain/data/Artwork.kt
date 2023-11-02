package com.valllent.shared.logic.domain.data

data class Artwork(
    val id: Long,
    val title: String,
    val description: String,
    val imageUrl: String? = null,
)