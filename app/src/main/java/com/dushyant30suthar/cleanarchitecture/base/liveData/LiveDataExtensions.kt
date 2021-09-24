package com.dushyant30suthar.cleanarchitecture.base.liveData

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<Outcome<T>>.observeK(
    owner: LifecycleOwner,
    crossinline onSuccess: (T) -> Unit = {},
    crossinline onError: (e: Throwable) -> Unit = {},
    crossinline onProgress: (Boolean) -> Unit = {}
) {
    this.observe(owner, Observer {
        when (it) {
            is Outcome.Success -> onSuccess(it.data)
            is Outcome.ApiError -> onError(it.e)
            is Outcome.Progress -> onProgress(it.loading)
        }
    })
}