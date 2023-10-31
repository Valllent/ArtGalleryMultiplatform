package com.valllent.shared.ui.di

import com.valllent.shared.logic.di.NetworkModule
import com.valllent.shared.logic.di.RepositoriesModule
import com.valllent.shared.logic.di.UseCasesModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object DependenciesInitializer {

    fun init(
        appModule: Module = module { },
    ): KoinApplication = startKoin {
        modules(
            appModule,
            UseCasesModule(),
            RepositoriesModule(),
            NetworkModule(),
            ViewModelsModule(),
        )
    }

}