package com.dushyant30suthar.nasapictures.base.rx

import io.reactivex.Single

interface SingleUseCase<T, PARAMS> {
    fun execute(param: PARAMS): Single<T>
}