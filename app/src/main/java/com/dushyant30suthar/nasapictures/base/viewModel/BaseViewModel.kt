package com.dushyant30suthar.nasapictures.base.viewModel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        if (compositeDisposable.isDisposed.not())
            compositeDisposable.dispose()
        super.onCleared()
        compositeDisposable.clear()
    }

}