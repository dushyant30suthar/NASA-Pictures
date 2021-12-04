package com.dushyant30suthar.cleanarchitecture.components.movieList.adapter

import android.view.ViewGroup
import com.dushyant30suthar.cleanarchitecture.base.action.ActionPerformer
import com.dushyant30suthar.cleanarchitecture.base.action.BaseAction
import com.dushyant30suthar.cleanarchitecture.base.adapter.BaseAdapter
import com.dushyant30suthar.cleanarchitecture.base.view.BaseViewHolder
import com.dushyant30suthar.cleanarchitecture.base.view.RecyclerViewItem

class MovieListAdapter(val actionPerformer: ActionPerformer<BaseAction>?) :
    BaseAdapter() {

    private val movieListViewHolderFactory = MovieListViewHolderFactory()

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecyclerViewItem, BaseAction> {
        return (movieListViewHolderFactory.getViewHolderFor(
            parent,
            viewType
        ) as BaseViewHolder<RecyclerViewItem, BaseAction>).apply {
            actionPerformer = this@MovieListAdapter.actionPerformer
        }
    }


}