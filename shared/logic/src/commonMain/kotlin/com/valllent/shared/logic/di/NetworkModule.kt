package com.valllent.shared.logic.di

import com.valllent.shared.logic.network.Client
import com.valllent.shared.logic.network.api.ArtworkApi
import org.koin.core.module.Module
import org.koin.dsl.module

object NetworkModule {

    operator fun invoke(): Module {
        return module {
            factory {
                Client.get()
            }
            factory {
                ArtworkApi(get())
            }
        }
    }

}