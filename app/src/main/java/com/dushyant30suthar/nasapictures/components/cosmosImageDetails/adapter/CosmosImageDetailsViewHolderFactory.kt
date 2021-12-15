package com.dushyant30suthar.nasapictures.components.cosmosImageDetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.base.adapter.ViewHolderFactory
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.components.cosmosImageDetails.actions.CosmosImageDetailsAction
import com.dushyant30suthar.nasapictures.components.cosmosImageDetails.viewHolder.CosmosImageDetailsItemViewHolder


class CosmosImageDetailsViewHolderFactory : ViewHolderFactory<CosmosImageDetailsAction> {

    override fun getViewHolderFor(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, CosmosImageDetailsAction> {
        return when (viewType) {

            R.layout.item_cosmos_image ->

                CosmosImageDetailsItemViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_cosmos_image_details,
                        parent,
                        false
                    )
                )


            else -> throw IllegalArgumentException()
        }
    }

}