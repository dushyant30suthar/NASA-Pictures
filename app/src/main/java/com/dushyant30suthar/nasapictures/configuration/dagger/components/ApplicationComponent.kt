package com.dushyant30suthar.nasapictures.configuration.dagger.components

import android.app.Application
import com.dushyant30suthar.nasapictures.configuration.dagger.modules.ApplicationModule
import com.dushyant30suthar.nasapictures.configuration.dagger.modules.BindingActivityModule
import com.dushyant30suthar.nasapictures.configuration.dagger.modules.BindingFragmentModule
import com.dushyant30suthar.nasapictures.configuration.dagger.modules.ViewModelProviderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        BindingActivityModule::class,
        ViewModelProviderModule::class,
        BindingFragmentModule::class,
    ]
)
@Singleton
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}