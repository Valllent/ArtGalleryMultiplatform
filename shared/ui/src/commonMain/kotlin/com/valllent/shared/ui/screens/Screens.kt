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
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkActions
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkScreen
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkViewModel
import moe.tlaster.precompose.koin.koinViewModel
import org.koin.core.parameter.parametersOf

sealed class ScreenType(
    val staticRoute: String
)

data object ArtworksListScreenType : ScreenType("artworks") {

    fun createRoute() = staticRoute

    @Composable
    fun Content(onItemClick: (Artwork) -> Unit, onSearchClick: () -> Unit) {
        val viewModel = koinViewModel(vmClass = ArtworksListViewModel::class)
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
            },
            onSearchClick = {
                onSearchClick()
            }
        )
        ArtworksListScreen(state, actions)
    }

}

data object DetailArtworkScreenType : ScreenType("artworks/{artworkId}") {

    fun createRoute(artworkId: Long) = "artworks/$artworkId"

    @Composable
    fun Content(
        artworkId: Long,
        onClickBack: () -> Unit,
    ) {
        val viewModel = koinViewModel(vmClass = DetailArtworkViewModel::class) {
            parametersOf(artworkId)
        }
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

data object SearchArtworkScreenType : ScreenType("artworks/search") {

    fun createRoute() = "artworks/search"

    @Composable
    fun Content(
        onClickBack: () -> Unit,
        onArtworkClick: (Artwork) -> Unit,
    ) {
        val viewModel = koinViewModel(vmClass = SearchArtworkViewModel::class)
        val state = viewModel.state.collectAsState().value
        val actions = SearchArtworkActions(
            onClickBack = onClickBack,
            onSearchRequestChange = {
                viewModel.setSearchRequest(it)
            },
            onSearchClick = {
                viewModel.search()
            },
            onArtworkClick = onArtworkClick,
            onRetryClick = {
                viewModel.requestNextPage()
            },
            onScrollToEnd = {
                viewModel.requestNextPage()
            }
        )

        SearchArtworkScreen(state, actions)
    }

}