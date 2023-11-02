package com.valllent.shared.ui.views.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RetryIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ProjectIconButton(
        modifier = modifier,
        text = "Retry",
        imageVector = Icons.Filled.Refresh,
        onClick = onClick
    )
}

@Composable
fun ProjectIconButton(
    text: String,
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier.padding(10.dp),
        onClick = onClick
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6
        )
        Icon(
            modifier = Modifier.padding(start = 16.dp),
            imageVector = imageVector,
            contentDescription = text
        )
    }
}