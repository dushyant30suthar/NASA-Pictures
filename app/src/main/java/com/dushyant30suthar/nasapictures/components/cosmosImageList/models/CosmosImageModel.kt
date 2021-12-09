package com.dushyant30suthar.nasapictures.components.cosmosImageList.models

import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

data class CosmosImageModel(
    val movieName: String,
    val releaseYear: String,
    val ratings: String,
    override val viewType: Int
) : RecyclerViewItem
