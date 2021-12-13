package com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers

import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.base.mapper.Mapper
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.ErrorModel
import retrofit2.HttpException
import javax.inject.Inject

/*
* Handle different kinds of error here. Map appropriate layout for type of error.
*
* Such as if there is error in database or error in network or something like that.*/
class CosmosImageListErrorMapper @Inject constructor() :
    Mapper<Throwable, RecyclerViewItem> {


    override fun map(srcObject: Throwable): RecyclerViewItem {

        return when (srcObject) {
            is HttpException -> {
                ErrorModel(
                    errorMessage = srcObject.message(),
                    viewType = R.layout.layout_error_cosmos_image_list
                )
            }
            else -> {
                ErrorModel(
                    errorMessage = "Unknown Error",
                    viewType = R.layout.layout_error_unknown_cosmos_image_list
                )
            }
        }


    }


}