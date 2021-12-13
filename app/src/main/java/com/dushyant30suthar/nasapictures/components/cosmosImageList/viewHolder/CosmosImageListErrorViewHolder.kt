package com.dushyant30suthar.nasapictures.components.cosmosImageList.viewHolder


import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.ErrorModel
import com.dushyant30suthar.nasapictures.databinding.LayoutErrorCosmosImageListBinding


class CosmosImageListErrorViewHolder(
    private val binding: LayoutErrorCosmosImageListBinding,
) : BaseViewHolder<ErrorModel, CosmosImageListAction>(binding.root) {


    override fun bind(
        data: ErrorModel,
        position: Int,
    ) {


    }

}