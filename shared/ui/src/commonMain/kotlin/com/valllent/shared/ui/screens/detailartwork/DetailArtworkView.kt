package com.valllent.shared.ui.screens.detailartwork

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.valllent.shared.logic.domain.data.DetailArtwork
import com.valllent.shared.ui.views.elements.BackButton
import com.valllent.shared.ui.views.elements.RetryIconButton
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource


data class DetailArtworkActions(
    val onClickBack: () -> Unit,
    val onRetryClick: () -> Unit,
)

sealed class DetailArtworkState {

    data class Loaded(
        val detailArtwork: DetailArtwork
    ) : DetailArtworkState()

    data object Loading : DetailArtworkState()

    data object LoadingFailed : DetailArtworkState()

}

@Composable
fun DetailArtworkScreenView(
    state: DetailArtworkState,
    actions: DetailArtworkActions
) {
    when (state) {
        is DetailArtworkState.Loaded -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                val department = remember { mutableStateOf("") }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BackButton(
                        modifier = Modifier
                            .padding(8.dp)
                            .height(45.dp)
                            .width(45.dp),
                        onClickBack = actions.onClickBack
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth()
                            .align(Alignment.CenterVertically)
                            .padding(end = 16.dp),
                        text = department.value,
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.h6
                    )
                }
                val artwork = state.detailArtwork
                LaunchedEffect(Unit) {
                    department.value = artwork.department
                }

                if (artwork.imageUrl != null) {
                    KamelImage(
                        modifier = Modifier.fillMaxWidth(),
                        resource = asyncPainterResource(artwork.imageUrl ?: ""),
                        contentDescription = artwork.title,
                    )
                }

                Text(
                    modifier = Modifier.padding(16.dp),
                    text = artwork.title,
                    style = MaterialTheme.typography.h4,
                )
                if (artwork.artistInfo.isNotBlank()) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1 / 2f)
                                .padding(16.dp)
                        ) {
                            if (artwork.date.isNotBlank()) {
                                Text(
                                    text = artwork.date,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                            if (artwork.materialsInfo.isNotBlank()) {
                                Text(
                                    text = artwork.materialsInfo
                                )
                            }
                            if (artwork.dimensions.isNotBlank()) {
                                Text(
                                    text = artwork.dimensions
                                )
                            }
                        }
                        Card(
                            modifier = Modifier
                                .weight(1 / 2f)
                                .align(Alignment.CenterVertically)
                                .padding(end = 16.dp),
                            elevation = 6.dp,
                            backgroundColor = MaterialTheme.colors.primarySurface,
                        ) {
                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = artwork.artistInfo
                            )
                        }
                    }
                }
                if (artwork.description.isNotBlank()) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        text = artwork.description,
                        style = MaterialTheme.typography.body1,
                    )
                }
                if (artwork.ownersHistory.isNotBlank()) {
                    Text(
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 10.dp
                        ),
                        text = artwork.ownersHistory,
                        style = MaterialTheme.typography.body1,
                    )
                }
            }
        }

        is DetailArtworkState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                BackButton(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                        .height(45.dp)
                        .width(45.dp),
                    onClickBack = actions.onClickBack
                )
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 8.dp)
                )
            }
        }

        is DetailArtworkState.LoadingFailed -> {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                BackButton(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                        .height(45.dp)
                        .width(45.dp),
                    onClickBack = actions.onClickBack
                )
                RetryIconButton(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 8.dp),
                    onClick = actions.onRetryClick
                )
            }
        }
    }
}