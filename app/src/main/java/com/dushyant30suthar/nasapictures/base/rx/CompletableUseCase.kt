package com.dushyant30suthar.nasapictures.base.rx

import io.reactivex.Completable

interface CompletableUseCase<PARAMS> {

    fun execute(param: PARAMS): Completable

}