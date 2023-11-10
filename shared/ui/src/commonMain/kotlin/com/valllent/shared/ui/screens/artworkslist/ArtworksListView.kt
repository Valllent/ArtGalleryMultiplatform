package com.valllent.shared.ui.screens.artworkslist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.pagination.PagerList
import com.valllent.shared.ui.views.ArtworksList
import com.valllent.shared.ui.views.elements.ProjectIconButtonWithText


data class ArtworksListActions(
    val onArtworkClick: (Artwork) -> Unit,
    val onLearnMoreClick: (Artwork) -> Unit,
    val onRetryClick: () -> Unit,
    val onScrollToEnd: () -> Unit,
    val onSearchClick: () -> Unit,
)

data class ArtworksListState(
    val artworks: PagerList<Artwork>,
)

@Composable
fun ArtworksListScreenView(
    state: ArtworksListState,
    actions: ArtworksListActions
) {
    ArtworksList(
        artworks = state.artworks,
        onScrollToEnd = actions.onScrollToEnd,
        onRetryClick = actions.onRetryClick,
        onArtworkClick = actions.onArtworkClick,
        onLearnMoreClick = actions.onLearnMoreClick,
        headItem = {
            if (state.artworks.data.isNotEmpty()) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ProjectIconButtonWithText(
                            text = "Search",
                            modifier = Modifier.align(Alignment.Center).padding(8.dp),
                            onClick = actions.onSearchClick,
                            imageVector = Icons.Filled.Search
                        )
                    }
                }
            }
        }
    )
}