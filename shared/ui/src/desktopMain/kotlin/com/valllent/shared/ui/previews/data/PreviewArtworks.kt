package com.valllent.shared.ui.previews.data

import com.valllent.shared.logic.domain.data.Artwork

object PreviewArtworks {

    fun getList(): List<Artwork> {
        return listOf(
            Artwork(
                id = 1,
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                description = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                artist = "Awesome Artist",
                imageUrl = "https://duck.com/image.jpg"
            ),
            Artwork(
                id = 3,
                title = "Without image",
                description = "Exercitation",
                artist = "Noone",
                imageUrl = null
            ),
            Artwork(
                id = 1,
                title = "Short title",
                description = "Short description",
                artist = "Unknown",
                imageUrl = "https://duck.com/image.jpg"
            ),
        )
    }

}