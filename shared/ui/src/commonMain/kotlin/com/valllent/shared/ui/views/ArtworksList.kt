package com.valllent.shared.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.pagination.LoadingState
import com.valllent.shared.ui.pagination.PagerList
import com.valllent.shared.ui.pagination.ScrollToEndTracker
import com.valllent.shared.ui.screens.artworkslist.ArtworkItem
import com.valllent.shared.ui.views.elements.RetryIconButton


@Composable
fun ArtworksList(
    artworks: PagerList<Artwork>,
    onArtworkClick: (Artwork) -> Unit,
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
                            ArtworkItem(it, onArtworkClick)
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