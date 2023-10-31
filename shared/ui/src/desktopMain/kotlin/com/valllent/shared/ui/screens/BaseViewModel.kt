package com.valllent.shared.ui.screens

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

actual abstract class BaseViewModel {

    private val job = SupervisorJob()

    actual fun getScope(): CoroutineScope {
        return CoroutineScope(job)
    }

}