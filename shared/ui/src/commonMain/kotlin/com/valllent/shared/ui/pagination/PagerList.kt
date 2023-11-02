package com.valllent.shared.ui.pagination

import androidx.compose.runtime.Stable

@Stable
data class PagerList<T>(
    val data: List<T>,
    val firstLoadingState: LoadingState,
    val appendLoadingState: LoadingState
)