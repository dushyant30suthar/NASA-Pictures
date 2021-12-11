package com.dushyant30suthar.nasapictures.data.cosmosImageList.services

import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import io.reactivex.Single
import retrofit2.http.GET

interface CosmosImageListService {
    @GET("api/cosmos/images/")
    fun getCosmosImageList(): Single<List<CosmosImageEntity>>
}