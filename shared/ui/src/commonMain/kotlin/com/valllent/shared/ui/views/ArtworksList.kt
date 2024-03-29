package com.valllent.shared.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.pagination.LoadingState
import com.valllent.shared.ui.pagination.PagerList
import com.valllent.shared.ui.pagination.ScrollToEndTracker
import com.valllent.shared.ui.views.elements.RetryIconButton
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource


@Composable
fun ArtworksList(
    artworks: PagerList<Artwork>,
    onArtworkClick: (Artwork) -> Unit,
    onLearnMoreClick: (Artwork) -> Unit,
    onScrollToEnd: () -> Unit,
    onRetryClick: () -> Unit,
    headItem: LazyListScope.() -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when (artworks.firstLoadingState) {
            LoadingState.NOT_LOADING -> {
                Column {
                    val listState = rememberLazyListState()
                    ScrollToEndTracker(listState, event = onScrollToEnd)
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        state = listState
                    ) {
                        headItem()
                        items(artworks.data) {
                            ArtworkItem(it, onArtworkClick, onLearnMoreClick)
                        }
                        if (artworks.appendLoadingState == LoadingState.LOADING) {
                            item {
                                Box(
                                    modifier = Modifier.fillMaxWidth()
                                        .height(100.dp)
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }
                            }
                        } else if (artworks.appendLoadingState == LoadingState.FAILED) {
                            item {
                                Box(
                                    modifier = Modifier.fillMaxWidth()
                                        .height(100.dp)
                                ) {
                                    RetryIconButton(
                                        modifier = Modifier.align(Alignment.Center),
                                        onClick = onRetryClick
                                    )
                                }
                            }
                        }
                    }
                }
            }

            LoadingState.FAILED -> {
                RetryIconButton(
                    modifier = Modifier.align(Alignment.Center),
                    onClick = onRetryClick
                )
            }

            LoadingState.LOADING -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArtworkItem(
    artwork: Artwork,
    onArtworkClick: (Artwork) -> Unit,
    onLearnMoreClick: (Artwork) -> Unit,
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
                        onLearnMoreClick(artwork)
                    }
                ) {
                    Text("Learn more")
                }
            }
        }
    }
}