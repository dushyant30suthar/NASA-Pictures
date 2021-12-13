package com.dushyant30suthar.nasapictures.base.liveData

import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

sealed class Outcome<T> {

    data class Progress<T>(var loading: Boolean) : Outcome<T>()
    data class Success<T>(var data: T) : Outcome<T>()
    data class ApiError<T>(val errorItem: RecyclerViewItem?) : Outcome<T>()
    companion object {

        fun <T> loading(isLoading: Boolean): Outcome<T> = Progress(isLoading)
        fun <T> success(data: T): Outcome<T> = Success(data)
        fun <T> apiError(errorItem: RecyclerViewItem?): Outcome<T> = ApiError(errorItem)

    }
}