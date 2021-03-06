package com.dushyant30suthar.nasapictures.components.cosmosImageList.di

import androidx.lifecycle.ViewModel
import com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel.CosmosImageListViewModel
import com.dushyant30suthar.nasapictures.configuration.dagger.annotations.ViewModelKey
import com.dushyant30suthar.nasapictures.configuration.dagger.scopes.PerFragment
import com.dushyant30suthar.nasapictures.data.cosmosImageList.services.CosmosService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module(
    includes = [CosmosImageListFragmentModule.CosmosImageListFragmentProviderModule::class]
)

abstract class CosmosImageListFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(CosmosImageListViewModel::class)
    @PerFragment
    abstract fun bindCosmosListViewModel(cosmosImageListViewModel: CosmosImageListViewModel): ViewModel


    @Module
    object CosmosImageListFragmentProviderModule {

        @Provides
        @PerFragment
        internal fun bindCosmosService(retrofit: Retrofit): CosmosService {
            return retrofit.create(
                CosmosService
                ::class.java
            )
        }

    }
}
