package com.valllent.shared.ui.screens.artworkslist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.views.ArtworksList
import com.valllent.shared.ui.views.elements.ProjectIconButtonWithText
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun ArtworksListScreen(
    state: ArtworksListState,
    actions: ArtworksListActions
) {
    ArtworksList(
        artworks = state.artworks,
        onScrollToEnd = actions.onScrollToEnd,
        onRetryClick = actions.onRetryClick,
        onArtworkClick = actions.onArtworkClick,
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArtworkItem(
    artwork: Artwork,
    onArtworkClick: (Artwork) -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(20.dp, 10.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        onClick = {
            onArtworkClick(artwork)
        }
    ) {
        Column {
            val imageUrl = artwork.imageUrl
            if (imageUrl != null) {
                KamelImage(
                    modifier = Modifier.fillMaxWidth().aspectRatio(2 / 1f),
                    resource = asyncPainterResource(imageUrl),
                    contentDescription = artwork.title,
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = artwork.title,
                    style = MaterialTheme.typography.h5,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                if (artwork.description.isNotBlank()) {
                    Text(
                        modifier = Modifier.padding(vertical = 5.dp),
                        text = artwork.description,
                        style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Button(
                    modifier = Modifier.align(Alignment.End),
                    onClick = {
                        onArtworkClick(artwork)
                    }
                ) {
                    Text("Learn more")
                }
            }
        }
    }
}