package com.valllent.shared.ui.screens.searchartwork

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.valllent.shared.ui.screens.Screen
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkScreen
import com.valllent.shared.ui.screens.fastinfodialog.FastInfoDialog
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.BackStackEntry


data object SearchArtworkScreen : Screen() {

    fun createRoute() = getStaticRoute()

    override fun getStaticRoute() = "artworks/search"

    @Composable
    override fun createComposable(screenParams: Params, backStackEntry: BackStackEntry) {

        val viewModel = koinViewModel(vmClass = SearchArtworkViewModel::class)
        val state = viewModel.state.collectAsState().value
        val actions = SearchArtworkActions(
            onClickBack = {
                screenParams.navigator.goBack()
            },
            onSearchRequestChange = {
                viewModel.setSearchRequest(it)
            },
            onSearchClick = {
                viewModel.search()
            },
            onArtworkClick = {
                screenParams.navigator.navigate(DetailArtworkScreen.createRoute(it.id))
            },
            onRetryClick = {
                viewModel.requestNextPage()
            },
            onScrollToEnd = {
                viewModel.requestNextPage()
            },
            onLearnMoreClick = {
                screenParams.navigator.navigate(FastInfoDialog.createRoute(it))
            }
        )

        SearchArtworkScreenView(state, actions)
    }

}