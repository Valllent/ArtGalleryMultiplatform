package com.valllent.shared.ui.screens.artworkslist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.valllent.shared.ui.screens.Screen
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkScreen
import com.valllent.shared.ui.screens.fastinfodialog.FastInfoDialog
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkScreen
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.BackStackEntry

data object ArtworksListScreen : Screen() {

    fun createRoute() = getStaticRoute()

    override fun getStaticRoute() = "artworks"

    @Composable
    override fun createComposable(screenParams: Params, backStackEntry: BackStackEntry) {
        val viewModel = koinViewModel(vmClass = ArtworksListViewModel::class)
        val state = viewModel.state.collectAsState().value
        val actions = ArtworksListActions(
            onArtworkClick = {
                screenParams.navigator.navigate(DetailArtworkScreen.createRoute(artworkId = it.id))
            },
            onLearnMoreClick = {
                screenParams.navigator.navigate(FastInfoDialog.createRoute(it))
            },
            onRetryClick = {
                viewModel.requestNextPage()
            },
            onScrollToEnd = {
                viewModel.requestNextPage()
            },
            onSearchClick = {
                screenParams.navigator.navigate(SearchArtworkScreen.createRoute())
            }
        )
        ArtworksListScreenView(state, actions)
    }

}