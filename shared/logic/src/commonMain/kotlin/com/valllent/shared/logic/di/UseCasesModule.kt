package com.valllent.shared.logic.di

import com.valllent.shared.logic.domain.usecases.GetArtworksUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

object UseCasesModule {

    operator fun invoke(): Module {
        return module {
            factory {
                GetArtworksUseCase(get())
            }
        }
    }

}