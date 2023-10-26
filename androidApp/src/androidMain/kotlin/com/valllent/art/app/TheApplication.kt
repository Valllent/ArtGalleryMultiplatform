package com.valllent.art.app

import android.app.Application
import com.valllent.shared.logic.di.DependenciesInitializer

class TheApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DependenciesInitializer.init()
    }

}