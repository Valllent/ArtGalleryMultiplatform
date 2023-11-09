package com.valllent.shared.logic.di

import com.valllent.shared.logic.domain.repositories.ArtworkRepository
import com.valllent.shared.logic.network.repositories.ArtworkRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

object RepositoriesModule {

    operator fun invoke(): Module {
        return module {
            single<ArtworkRepository> {
                ArtworkRepositoryImpl(get())
            }
        }
    }

}