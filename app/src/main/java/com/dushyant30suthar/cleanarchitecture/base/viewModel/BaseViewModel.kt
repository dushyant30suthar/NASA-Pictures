package com.dushyant30suthar.cleanarchitecture.base.viewModel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    abstract fun getCommonProperties(): HashMap<String, Any>?

    override fun onCleared() {
        if (compositeDisposable.isDisposed.not())
            compositeDisposable.dispose()
        super.onCleared()
        compositeDisposable.clear()
    }

}