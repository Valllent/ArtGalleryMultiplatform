package com.valllent.shared.ui.screens.searchartwork

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.valllent.shared.ui.views.ArtworksList
import com.valllent.shared.ui.views.elements.BackButton

@Composable
fun SearchArtworkScreen(
    state: SearchArtworkState,
    actions: SearchArtworkActions,
) {
    Column {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackButton(
                modifier = Modifier
                    .padding(end = 16.dp, top = 4.dp)
                    .width(50.dp)
                    .height(50.dp),
                onClickBack = actions.onClickBack
            )

            val textFieldValue = remember { mutableStateOf(state.searchQuery) }
            LaunchedEffect(textFieldValue.value) {
                actions.onSearchRequestChange(textFieldValue.value)
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
                label = {
                    Text(
                        text = "Search Request"
                    )
                },
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.primary,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                ),
                keyboardActions = KeyboardActions {
                    actions.onSearchClick()
                },
                trailingIcon = {
                    IconButton(
                        onClick = actions.onSearchClick
                    ) {
                        Icon(
                            Icons.Filled.Search,
                            "Search",
                        )
                    }
                }
            )
        }

        val artworks = state.artworksPagerList
        if (artworks != null) {
            ArtworksList(
                artworks = artworks,
                onArtworkClick = actions.onArtworkClick,
                onScrollToEnd = actions.onScrollToEnd,
                onRetryClick = actions.onRetryClick,
                headItem = {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center,
                        ) {
                            Row {
                                Text(
                                    text = "Search query: ",
                                )
                                Text(
                                    text = state.lastSentSearchQuery,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}