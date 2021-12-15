package com.dushyant30suthar.nasapictures.data.cosmosImageList.repository

import com.dushyant30suthar.nasapictures.data.cosmosImageList.services.CosmosService
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import io.reactivex.Single
import javax.inject.Inject

class CosmosImageListRepository @Inject constructor(
    private val cosmosService: CosmosService
) {
    fun getCosmosImageList(): Single<List<CosmosImageEntity>> {
        return cosmosService.getCosmosImageList()
    }
}