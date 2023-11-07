package com.valllent.art.app

import android.app.Application
import com.valllent.shared.ui.di.DependenciesInitializer
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class TheApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Napier.base(DebugAntilog())
        DependenciesInitializer.init()
    }

}