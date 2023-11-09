package com.valllent.shared.ui.previews

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.valllent.shared.ui.pagination.LoadingState
import com.valllent.shared.ui.pagination.PagerList
import com.valllent.shared.ui.previews.data.PreviewArtworks
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkActions
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkScreen
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkState


private val actions = SearchArtworkActions({}, {}, {}, {}, {}, {})

@Preview
@Composable
fun SearchArtworkScreenPreview_Initial() {
    SearchArtworkScreen(
        state = SearchArtworkState("", "", null),
        actions = actions,
    )
}

@Preview
@Composable
fun SearchArtworkScreenPreview_WithItems() {
    SearchArtworkScreen(
        state = SearchArtworkState(
            "love",
            "love",
            PagerList(PreviewArtworks.getList(), LoadingState.NOT_LOADING, LoadingState.NOT_LOADING)
        ),
        actions = actions,
    )
}