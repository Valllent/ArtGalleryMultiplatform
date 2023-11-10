package com.valllent.shared.ui.screens

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.valllent.shared.ui.screens.artworkslist.ArtworksListScreen
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkScreen
import com.valllent.shared.ui.screens.fastinfodialog.FastInfoDialog
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkScreen
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

                NavHost(
                    modifier = Modifier,
                    navigator = navigator,
                    initialRoute = ArtworksListScreen.getStaticRoute(),
                    navTransition = transitionEffects(),
                ) {
                    val params = Screen.Params(this, navigator)

                    ArtworksListScreen.createScene(params)
                    DetailArtworkScreen.createScene(params)
                    SearchArtworkScreen.createScene(params)

                    FastInfoDialog.createScene(params, Screen.Type.DIALOG)
                }
            }
        }
    }
}


private fun transitionEffects(): NavTransition {
    val slideOut = slideOutHorizontally(
        targetOffsetX = { it }
    )
    val slideIn = slideInHorizontally(
        initialOffsetX = { it }
    )
    return NavTransition(
        createTransition = fadeIn() + slideIn,
        resumeTransition = fadeIn(),
        destroyTransition = fadeOut() + slideOut,
        pauseTransition = fadeOut(),
    )
}