package com.valllent.art.app

import android.app.Application
import com.valllent.shared.ui.di.DependenciesInitializer

class TheApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DependenciesInitializer.init()
    }

}