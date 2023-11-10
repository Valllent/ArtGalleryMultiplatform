package com.valllent.shared.ui.previews

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.pagination.LoadingState
import com.valllent.shared.ui.pagination.PagerList
import com.valllent.shared.ui.previews.data.PreviewArtworks
import com.valllent.shared.ui.screens.artworkslist.ArtworksListActions
import com.valllent.shared.ui.screens.artworkslist.ArtworksListScreenView
import com.valllent.shared.ui.screens.artworkslist.ArtworksListState

private val actions = ArtworksListActions({}, {}, {}, {}, {})

private fun createState(
    pagerList: PagerList<Artwork>,
): ArtworksListState {
    return ArtworksListState(pagerList)
}

@Composable
@Preview
fun ArtworksListScreenPreview_Loading() {
    ArtworksListScreenView(
        state = createState(
            PagerList(
                emptyList(),
                LoadingState.LOADING,
                LoadingState.NOT_LOADING
            )
        ),
        actions = actions
    )
}

@Composable
@Preview
fun ArtworksListScreenPreview_Failed() {
    ArtworksListScreenView(
        state = createState(
            PagerList(
                emptyList(),
                LoadingState.FAILED,
                LoadingState.NOT_LOADING
            )
        ),
        actions = actions
    )
}

@Composable
@Preview
fun ArtworksListScreenPreview_ManyItems() {
    val list = PreviewArtworks.getList()
    ArtworksListScreenView(
        state = createState(
            PagerList(
                list,
                LoadingState.NOT_LOADING,
                LoadingState.NOT_LOADING
            )
        ),
        actions = actions
    )
}

@Composable
@Preview
fun ArtworksListScreenPreview_OneItemWithAppendLoading() {
    val list = listOf(PreviewArtworks.getList().first())
    ArtworksListScreenView(
        state = createState(
            PagerList(
                list,
                LoadingState.NOT_LOADING,
                LoadingState.LOADING
            )
        ),
        actions = actions
    )
}