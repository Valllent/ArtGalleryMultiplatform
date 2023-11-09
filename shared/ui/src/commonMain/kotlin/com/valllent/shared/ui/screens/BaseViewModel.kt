package com.valllent.shared.ui.screens

import kotlinx.coroutines.CoroutineScope
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

abstract class BaseViewModel : ViewModel() {

    protected val scope: CoroutineScope
        get() = viewModelScope

}