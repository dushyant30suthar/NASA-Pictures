package com.dushyant30suthar.nasapictures.data.cosmosImageList.repository

import com.dushyant30suthar.nasapictures.data.cosmosImageList.services.CosmosDataStorage
import com.dushyant30suthar.nasapictures.data.cosmosImageList.services.CosmosService
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import io.reactivex.Single
import javax.inject.Inject

open class CosmosImageListRepository @Inject constructor(
    private val cosmosService: CosmosService,
    private val cosmosDataStorage: CosmosDataStorage
) {

    fun getCosmosImageList(): Single<List<CosmosImageEntity>> {
        return cosmosService.getCosmosImageList()
    }

    fun bookCosmosImage(imageId: String) {
        cosmosDataStorage.toggleCosmosImageBookmark(imageId)
    }
}