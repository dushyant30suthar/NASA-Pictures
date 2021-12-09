package com.dushyant30suthar.nasapictures.components.movieList.adapter

import android.view.ViewGroup
import com.dushyant30suthar.nasapictures.base.action.ActionPerformer
import com.dushyant30suthar.nasapictures.base.adapter.BaseAdapter
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.base.view.RecyclerViewItem
import com.dushyant30suthar.nasapictures.components.movieList.actions.MovieListAction

class MovieListAdapter(val actionPerformer: ActionPerformer<MovieListAction>?) :
    BaseAdapter<MovieListAction>() {

    private val movieListViewHolderFactory = MovieListViewHolderFactory()

    override fun getViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecyclerViewItem, MovieListAction> {
        return (movieListViewHolderFactory.getViewHolderFor(
            parent,
            viewType
        ) as BaseViewHolder<RecyclerViewItem, MovieListAction>).apply {
            actionPerformer = this@MovieListAdapter.actionPerformer
        }
    }


}