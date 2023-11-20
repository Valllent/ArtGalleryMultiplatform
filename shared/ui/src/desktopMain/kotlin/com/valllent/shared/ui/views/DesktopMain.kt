package com.valllent.shared.ui.views

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.valllent.shared.ui.screens.SharedApp

fun startUi() {
    application {
        val windowState = rememberWindowState(
            width = 600.dp,
            height = 900.dp
        )

        Window(
            title = "Art",
            icon = painterResource("icon_launcher_round.webp"),
            state = windowState,
            onCloseRequest = ::exitApplication
        ) {
            SharedApp()
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    SharedApp()
}