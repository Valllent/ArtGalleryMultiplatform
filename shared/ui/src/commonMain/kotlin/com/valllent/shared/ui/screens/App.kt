package com.valllent.shared.ui.screens

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import org.koin.compose.KoinContext

@Composable
fun SharedApp() {
    PreComposeApp {
        KoinContext {
            MaterialTheme {
                val navigator = rememberNavigator()
                val effects = NavTransition(
                    createTransition = fadeIn(),
                    destroyTransition = fadeOut(),
                )
                NavHost(
                    modifier = Modifier,
                    navigator = navigator,
                    initialRoute = ArtworksListScreenType.staticRoute,
                    navTransition = effects,
                ) {
                    scene(
                        route = ArtworksListScreenType.staticRoute
                    ) {
                        ArtworksListScreenType.Content(
                            onItemClick = {
                                navigator.navigate(DetailArtworkScreenType.createRoute(artworkId = it.id))
                            },
                            onSearchClick = {
                                navigator.navigate(SearchArtworkScreenType.createRoute())
                            }
                        )
                    }

                    scene(
                        route = SearchArtworkScreenType.staticRoute
                    ) {
                        SearchArtworkScreenType.Content(
                            onClickBack = {
                                navigator.goBack()
                            },
                            onArtworkClick = {
                                navigator.navigate(DetailArtworkScreenType.createRoute(it.id))
                            }
                        )
                    }

                    scene(
                        route = DetailArtworkScreenType.staticRoute
                    ) { backStackEntry ->
                        val pathMap = backStackEntry.pathMap
                        val artworkId = pathMap["artworkId"]?.toLong() ?: 129884

                        DetailArtworkScreenType.Content(
                            artworkId = artworkId,
                            onClickBack = {
                                navigator.goBack()
                            }
                        )
                    }
                }
            }
        }
    }
}