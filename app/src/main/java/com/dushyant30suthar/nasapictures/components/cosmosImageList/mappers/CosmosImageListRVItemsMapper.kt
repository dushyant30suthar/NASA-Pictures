package com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers

import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.base.mapper.Mapper
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.CosmosImageModel
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import javax.inject.Inject

class CosmosImageListRVItemsMapper @Inject constructor() :
    Mapper<List<CosmosImageEntity>, List<RecyclerViewItem>> {


    override fun map(srcObject: List<CosmosImageEntity>): List<CosmosImageModel> {

        return srcObject.map {
            CosmosImageModel(
                imageUrl = it.url,
                imageTitle = it.title,
                date = it.date,
                viewType = R.layout.item_cosmos_image
            )
        }

    }


}