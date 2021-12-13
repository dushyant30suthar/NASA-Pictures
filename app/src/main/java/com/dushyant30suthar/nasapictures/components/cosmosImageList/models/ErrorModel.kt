package com.dushyant30suthar.nasapictures.components.cosmosImageList.models

import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem

data class ErrorModel(
    val errorMessage: String,
    override val viewType: Int
) : RecyclerViewItem
