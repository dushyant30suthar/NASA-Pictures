package com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter

import android.view.ViewGroup
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.adapter.BaseAdapter
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction

class CosmosImageListAdapter(
    private val actionPerformer: ActionPerformer<CosmosImageListAction>?,
    private val viewHolderFactory: CosmosImageListViewHolderFactory
) :
    BaseAdapter<CosmosImageListAction>() {


    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecyclerViewItem, CosmosImageListAction> {
        return (viewHolderFactory.getViewHolderFor(
            parent,
            viewType
        ) as BaseViewHolder<RecyclerViewItem, CosmosImageListAction>).apply {
            actionPerformer = this@CosmosImageListAdapter.actionPerformer
        }
    }


}