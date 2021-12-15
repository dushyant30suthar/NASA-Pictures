package com.dushyant30suthar.nasapictures.components.cosmosImageDetails.viewHolder


import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.base.viewModel.loadImage
import com.dushyant30suthar.nasapictures.components.cosmosImageDetails.actions.CosmosImageDetailsAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.CosmosImageModel
import com.dushyant30suthar.nasapictures.databinding.ItemCosmosImageDetailsBinding


class CosmosImageDetailsItemViewHolder(
    private val binding: ItemCosmosImageDetailsBinding,
) : BaseViewHolder<CosmosImageModel, CosmosImageDetailsAction>(binding.root) {


    override fun bind(
        data: CosmosImageModel,
        position: Int,
    ) {

        binding.cosmosImageIV.loadImage(data.imageUrl)
        binding.cosmosImageTitleTV.text = data.imageTitle
        binding.cosmosImageDateTV.text = data.date
        binding.cosmosImageDetailsTV.text = data.imageDescription

        binding.executePendingBindings()
    }

}