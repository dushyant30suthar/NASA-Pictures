package com.dushyant30suthar.nasapictures.data.cosmosImageList.repository

import com.dushyant30suthar.nasapictures.data.cosmosImageList.services.CosmosImageListService
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class CosmosImageListRepository @Inject constructor(
    private val cosmosImageListService: CosmosImageListService
) {
    fun getCosmosImageList(): Single<List<CosmosImageEntity>> {
        return Single.just(ArrayList())
    }
}