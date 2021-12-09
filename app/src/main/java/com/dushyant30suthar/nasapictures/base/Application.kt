package com.dushyant30suthar.nasapictures.base

import com.dushyant30suthar.nasapictures.configuration.dagger.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class Application : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?> {
        return DaggerApplicationComponent.builder().application(this).build()
    }
}