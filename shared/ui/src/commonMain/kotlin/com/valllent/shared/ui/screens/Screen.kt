package com.valllent.shared.ui.screens

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.BackStackEntry
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder


abstract class Screen {

    abstract fun getStaticRoute(): String

    @Composable
    abstract fun createComposable(screenParams: Params, backStackEntry: BackStackEntry)

    fun createScene(
        screenParams: Params,
        type: Type = Type.SCENE,
    ) {
        when (type) {
            Type.SCENE -> {
                screenParams.routeBuilder.scene(getStaticRoute()) {
                    createComposable(screenParams, it)
                }
            }

            Type.DIALOG -> {
                screenParams.routeBuilder.dialog(getStaticRoute()) {
                    createComposable(screenParams, it)
                }
            }
        }
    }

    enum class Type {
        SCENE,
        DIALOG
    }

    data class Params(
        val routeBuilder: RouteBuilder,
        val navigator: Navigator,
    )

}