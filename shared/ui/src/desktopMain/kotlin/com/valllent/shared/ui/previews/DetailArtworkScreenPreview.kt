package com.valllent.shared.ui.previews

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.valllent.shared.ui.previews.data.PreviewDetailArtworks
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkActions
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkScreenView
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkState


private val actions = DetailArtworkActions({}, {})

@Preview
@Composable
fun DetailArtworkScreenPreview_Loaded() {
    DetailArtworkScreenView(
        state = DetailArtworkState.Loaded(PreviewDetailArtworks.get()),
        actions = actions,
    )
}

@Preview
@Composable
fun DetailArtworkScreenPreview_LoadingFailed() {
    DetailArtworkScreenView(
        state = DetailArtworkState.LoadingFailed,
        actions = actions,
    )
}

@Preview
@Composable
fun DetailArtworkScreenPreview_Loading() {
    DetailArtworkScreenView(
        state = DetailArtworkState.Loading,
        actions = actions,
    )
}