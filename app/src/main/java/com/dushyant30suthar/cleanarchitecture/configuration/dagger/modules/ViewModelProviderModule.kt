package com.dushyant30suthar.cleanarchitecture.configuration.dagger.modules

import androidx.lifecycle.ViewModelProvider
import com.dushyant30suthar.cleanarchitecture.configuration.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}