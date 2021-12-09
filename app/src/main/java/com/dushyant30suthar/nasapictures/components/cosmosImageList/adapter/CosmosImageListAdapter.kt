package com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter

import android.view.ViewGroup
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.adapter.BaseAdapter
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.CosmosImageListAction

class CosmosImageListAdapter(val actionPerformer: ActionPerformer<CosmosImageListAction>?) :
    BaseAdapter<CosmosImageListAction>() {

    private val movieListViewHolderFactory = CosmosImageListViewHolderFactory()

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecyclerViewItem, CosmosImageListAction> {
        return (movieListViewHolderFactory.getViewHolderFor(
            parent,
            viewType
        ) as BaseViewHolder<RecyclerViewItem, CosmosImageListAction>).apply {
            actionPerformer = this@CosmosImageListAdapter.actionPerformer
        }
    }


}