package com.dushyant30suthar.nasapictures.components.cosmosImageDetails.di

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
    includes = [CosmosImageDetailsFragmentModule.CosmosImageListFragmentProviderModule::class]
)

abstract class CosmosImageDetailsFragmentModule {

    /*
    * Binding to the same ViewModel as it doesn't have any thing different to consume or ask for.*/
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
