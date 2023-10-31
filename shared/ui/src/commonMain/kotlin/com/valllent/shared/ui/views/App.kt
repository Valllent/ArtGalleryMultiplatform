package com.valllent.shared.ui.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.valllent.shared.ui.screens.artworkslist.ArtworksListViewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            ArtworksListScreen()
        }
    }
}

@Composable
fun ArtworksListScreen(
    viewModel: ArtworksListViewModel = koinInject()
) {
    val state = viewModel.state.collectAsState().value
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(state.artworks.joinToString())
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TempScreen() {
    val showImage by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        AnimatedVisibility(showImage) {
            Image(
                painterResource("compose-multiplatform.xml"),
                contentDescription = "Compose Multiplatform icon"
            )
        }
    }
}