package com.valllent.shared.ui.views

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.valllent.shared.ui.screens.artworkslist.ArtworksListActions
import com.valllent.shared.ui.screens.artworkslist.ArtworksListScreen
import com.valllent.shared.ui.screens.artworkslist.ArtworksListViewModel
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun SharedApp() {
    MaterialTheme {
        KoinContext {
            val viewModel = koinInject<ArtworksListViewModel>()
            val state = viewModel.state.collectAsState().value
            val actions = ArtworksListActions(
                onArtworkClick = {

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
}