package com.valllent.shared.ui.screens.fastinfodialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.valllent.shared.logic.domain.data.Artwork


data class FastInfoState(
    val artwork: Artwork,
)

data class FastInfoActions(
    val onGoBack: () -> Unit,
)

@Composable
fun FastInfoDialogView(
    state: FastInfoState,
    actions: FastInfoActions,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.3f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = actions.onGoBack,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(0.65f),
            contentAlignment = Alignment.Center,
        ) {
            Card(
                modifier = Modifier,
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = state.artwork.title,
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (state.artwork.artist.isNotBlank()) {
                        Text(
                            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp),
                            text = state.artwork.artist,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    if (state.artwork.description.isNotBlank()) {
                        Text(
                            modifier = Modifier,
                            text = state.artwork.description,
                            style = MaterialTheme.typography.body1,
                        )
                    }
                }
            }
        }
    }
}