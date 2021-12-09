package com.dushyant30suthar.nasapictures.configuration.dagger.modules

import com.dushyant30suthar.nasapictures.components.cosmosImageList.di.CosmosImageListFragmentModule
import com.dushyant30suthar.nasapictures.components.cosmosImageList.ui.CosmosImageListFragment
import com.dushyant30suthar.nasapictures.configuration.dagger.scopes.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingFragmentModule {

    @ContributesAndroidInjector(modules = [CosmosImageListFragmentModule::class])
    @PerFragment
    internal abstract fun contributeCosmosImageListFragmentInjector(): CosmosImageListFragment

}