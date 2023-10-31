package com.valllent.shared.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual abstract class BaseViewModel : ViewModel() {

    actual fun getScope(): CoroutineScope {
        return viewModelScope
    }

}