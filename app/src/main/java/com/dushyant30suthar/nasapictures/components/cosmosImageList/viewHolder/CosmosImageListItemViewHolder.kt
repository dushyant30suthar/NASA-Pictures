package com.dushyant30suthar.nasapictures.components.cosmosImageList.viewHolder


import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.base.viewModel.loadImage
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.CosmosImageModel
import com.dushyant30suthar.nasapictures.databinding.ItemCosmosImageBinding


class CosmosImageListItemViewHolder(
    private val binding: ItemCosmosImageBinding,
) : BaseViewHolder<CosmosImageModel, CosmosImageListAction>(binding.root) {


    override fun bind(
        data: CosmosImageModel,
        position: Int,
    ) {

        binding.cosmosImageIV.loadImage(data.imageUrl)
        binding.cosmosImageTitleTV.text = data.imageTitle
        binding.cosmosImageDateTV.text = data.date

        binding.executePendingBindings()
    }

}