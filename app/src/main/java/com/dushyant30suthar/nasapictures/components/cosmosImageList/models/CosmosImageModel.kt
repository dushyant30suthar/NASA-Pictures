package com.dushyant30suthar.nasapictures.components.cosmosImageList.models

import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

data class CosmosImageModel(
    val imageUrl: String,
    val imageTitle: String,
    val imageDescription: String,
    val date: String,
    val id: String,
    val isBookmarked: Boolean,
    override val viewType: Int
) : RecyclerViewItem
