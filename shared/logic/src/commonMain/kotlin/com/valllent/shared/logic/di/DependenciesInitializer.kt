package com.valllent.shared.logic.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.core.module.Module as KoinModule

object DependenciesInitializer {

    fun init(
        appModule: KoinModule = module { },
    ): KoinApplication = startKoin {
        modules(
            appModule,
            UseCasesModule(),
            RepositoriesModule(),
            NetworkModule()
        )
    }

}