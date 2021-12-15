package com.dushyant30suthar.nasapictures.components.cosmosImageDetails.adapter

import android.view.ViewGroup
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.adapter.BaseAdapter
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.components.cosmosImageDetails.actions.CosmosImageDetailsAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter.CosmosImageListViewHolderFactory

class CosmosImageDetailsAdapter(
    private val actionPerformer: ActionPerformer<CosmosImageDetailsAction>?,
    private val viewHolderFactory: CosmosImageListViewHolderFactory
) :
    BaseAdapter<CosmosImageDetailsAction>() {


    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecyclerViewItem, CosmosImageDetailsAction> {
        return (viewHolderFactory.getViewHolderFor(
            parent,
            viewType
        ) as BaseViewHolder<RecyclerViewItem, CosmosImageDetailsAction>).apply {
            actionPerformer = this@CosmosImageDetailsAdapter.actionPerformer
        }
    }


}