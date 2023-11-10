package com.valllent.shared.ui.screens.detailartwork

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.valllent.shared.ui.screens.Screen
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.BackStackEntry
import org.koin.core.parameter.parametersOf


data object DetailArtworkScreen : Screen() {

    fun createRoute(artworkId: Long) = "artworks/$artworkId"

    override fun getStaticRoute() = "artworks/{artworkId}"

    @Composable
    override fun createComposable(screenParams: Params, backStackEntry: BackStackEntry) {
        val pathMap = backStackEntry.pathMap
        val artworkId = pathMap["artworkId"]?.toLong() ?: 129884

        val viewModel = koinViewModel(vmClass = DetailArtworkViewModel::class) {
            parametersOf(artworkId)
        }
        val state = viewModel.state.collectAsState().value
        val actions = DetailArtworkActions(
            onClickBack = {
                screenParams.navigator.goBack()
            },
            onRetryClick = {
                viewModel.retry()
            }
        )

        DetailArtworkScreen(state, actions)
    }

}