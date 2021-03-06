package com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.base.adapter.ViewHolderFactory
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.viewHolder.CosmosImageListItemViewHolder


class CosmosImageListViewHolderFactory : ViewHolderFactory<CosmosImageListAction> {

    override fun getViewHolderFor(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, CosmosImageListAction> {
        return when (viewType) {

            R.layout.item_cosmos_image ->
                CosmosImageListItemViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_cosmos_image,
                        parent,
                        false
                    )
                )


            else -> throw IllegalArgumentException()
        }
    }

}