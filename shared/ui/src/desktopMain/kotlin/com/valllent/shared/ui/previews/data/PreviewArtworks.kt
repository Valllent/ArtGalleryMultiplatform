package com.valllent.shared.ui.previews.data

import com.valllent.shared.logic.domain.data.Artwork

object PreviewArtworks {

    fun getList(): List<Artwork> {
        return listOf(
            Artwork(
                1,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://duck.com/image.jpg"
            ),
            Artwork(
                3,
                "Without image",
                "Exercitation",
                null
            ),
            Artwork(
                1,
                "Short title",
                "Short description",
                "https://duck.com/image.jpg"
            ),
        )
    }

}