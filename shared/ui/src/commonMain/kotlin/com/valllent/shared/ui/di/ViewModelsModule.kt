package com.valllent.shared.ui.di

import com.valllent.shared.ui.screens.artworkslist.ArtworksListViewModel
import com.valllent.shared.ui.screens.detailartwork.DetailArtworkViewModel
import com.valllent.shared.ui.screens.searchartwork.SearchArtworkViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelsModule {

    operator fun invoke(): Module {
        return module {
            factory {
                ArtworksListViewModel(get())
            }
            factory { (artworkId: Int) ->
                DetailArtworkViewModel(artworkId, get())
            }
            factory {
                SearchArtworkViewModel(get())
            }
        }
    }

}