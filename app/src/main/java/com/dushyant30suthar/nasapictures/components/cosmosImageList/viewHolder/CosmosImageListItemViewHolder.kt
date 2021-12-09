package com.dushyant30suthar.nasapictures.components.cosmosImageList.viewHolder


import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.CosmosImageModel
import com.dushyant30suthar.nasapictures.databinding.ItemMovieBinding


class CosmosImageListItemViewHolder(
    private val binding: ItemMovieBinding,
) : BaseViewHolder<CosmosImageModel, CosmosImageListAction>(binding.root) {


    override fun bind(
        data: CosmosImageModel,
        position: Int,
    ) {


    }

}