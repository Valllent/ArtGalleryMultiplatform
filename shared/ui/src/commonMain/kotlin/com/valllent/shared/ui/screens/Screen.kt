package com.valllent.shared.ui.screens

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.BackStackEntry
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder


abstract class Screen {

    abstract fun getStaticRoute(): String

    @Composable
    abstract fun createComposable(screenParams: Params, backStackEntry: BackStackEntry)

    fun createScene(screenParams: Params) {
        screenParams.routeBuilder.scene(getStaticRoute()) {
            createComposable(screenParams, it)
        }
    }

    data class Params(
        val routeBuilder: RouteBuilder,
        val navigator: Navigator,
    )

}