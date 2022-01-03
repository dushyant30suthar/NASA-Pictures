package com.dushyant30suthar.nasapictures.data.cosmosImageList.services

import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity

class CosmosDataStorage() {

    val cosmosImageList: MutableList<CosmosImageEntity> = mutableListOf()

    fun updateCosmosImageList(updatedCosmoImageList: MutableList<CosmosImageEntity>) {
        cosmosImageList.clear()
        cosmosImageList.addAll(updatedCosmoImageList)
    }

    fun toggleCosmosImageBookmark(id: String) {


        cosmosImageList.addAll(cosmosImageList.filter {
            id == it.id
        }.map {
            it.copy(isBookmarked = false)
        })

    }


}