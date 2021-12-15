package com.dushyant30suthar.nasapictures.data.cosmosImageList.services

import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import io.reactivex.Single
import retrofit2.http.GET

/*
* We are using model class of domain layer as we do not have much complex data
* otherwise this layer would return data in it's own data classes / entities
* along with different model classes on domain and presentation layer as well.*/
interface CosmosService {
    @GET("api/cosmos/images/")
    fun getCosmosImageList(): Single<List<CosmosImageEntity>>
}