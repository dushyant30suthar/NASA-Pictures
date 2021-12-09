package com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers

import com.dushyant30suthar.nasapictures.base.mapper.Mapper
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import javax.inject.Inject

class CosmosImageListRVItemsMapper @Inject constructor() :
    Mapper<Any?, List<RecyclerViewItem>> {


    override fun map(srcObject: Any?): List<RecyclerViewItem> {
        return mutableListOf()
    }


}