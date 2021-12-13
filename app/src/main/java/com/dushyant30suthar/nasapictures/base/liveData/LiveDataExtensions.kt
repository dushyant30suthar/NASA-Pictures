package com.dushyant30suthar.nasapictures.base.liveData

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

inline fun <T> LiveData<Outcome<T>>.observeK(
    owner: LifecycleOwner,
    crossinline onSuccess: (T) -> Unit = {},
    crossinline onError: (e: RecyclerViewItem?) -> Unit = {},
    crossinline onProgress: (Boolean) -> Unit = {}
) {
    this.observe(owner, Observer {
        when (it) {
            is Outcome.Success -> onSuccess(it.data)
            is Outcome.ApiError -> onError(it.errorItem)
            is Outcome.Progress -> onProgress(it.loading)
        }
    })
}