package com.valllent.shared.ui.screens

import kotlinx.coroutines.CoroutineScope

expect abstract class BaseViewModel() {

    fun getScope(): CoroutineScope

}