package com.valllent.shared.ui.screens.fastinfodialog

import androidx.compose.runtime.Composable
import com.valllent.shared.logic.domain.data.Artwork
import com.valllent.shared.ui.screens.Screen
import moe.tlaster.precompose.navigation.BackStackEntry

data object FastInfoDialog : Screen() {

    fun createRoute(artwork: Artwork): String {
        ArtworkCacheUtils.put(artwork)
        return "artworks/dialog"
    }

    override fun getStaticRoute() = "artworks/dialog"

    @Composable
    override fun createComposable(
        screenParams: Params,
        backStackEntry: BackStackEntry
    ) {
        val artwork = ArtworkCacheUtils.get() ?: return
        val state = FastInfoState(artwork)
        val actions = FastInfoActions(
            onGoBack = {
                screenParams.navigator.goBack()
            }
        )

        FastInfoDialogView(state, actions)
    }
}