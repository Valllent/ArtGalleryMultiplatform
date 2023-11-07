package com.valllent.shared.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.screens.artworkslist.ArtworksListActions
import com.valllent.shared.ui.screens.artworkslist.ArtworksListScreen
import com.valllent.shared.ui.screens.artworkslist.ArtworksListViewModel
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkActions
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkScreen
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

sealed class ScreenType(
    val staticRoute: String
)

object ArtworksListScreenType : ScreenType("artworks") {

    fun createRoute() = staticRoute

    @Composable
    fun Content(onItemClick: (Artwork) -> Unit) {
        val viewModel = koinInject<ArtworksListViewModel>()
        val state = viewModel.state.collectAsState().value
        val actions = ArtworksListActions(
            onArtworkClick = {
                onItemClick(it)
            },
            onRetryClick = {
                viewModel.requestNextPage()
            },
            onScrollToEnd = {
                viewModel.requestNextPage()
            }
        )
        ArtworksListScreen(state, actions)
    }

}

object DetailArtworkScreenType : ScreenType("artworks/{artworkId}") {

    fun createRoute(artworkId: Long) = "artworks/$artworkId"

    @Composable
    fun Content(
        artworkId: Long,
        onClickBack: () -> Unit,
    ) {
        val viewModel = koinInject<DetailArtworkViewModel>(
            parameters = {
                parametersOf(artworkId)
            }
        )
        val state = viewModel.state.collectAsState().value
        val actions = DetailArtworkActions(
            onClickBack = onClickBack,
            onRetryClick = {
                viewModel.retry()
            }
        )

        DetailArtworkScreen(state, actions)
    }

}