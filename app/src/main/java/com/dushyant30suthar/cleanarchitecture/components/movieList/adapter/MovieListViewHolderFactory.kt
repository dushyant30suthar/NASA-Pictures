package com.dushyant30suthar.cleanarchitecture.components.movieList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dushyant30suthar.cleanarchitecture.R
import com.dushyant30suthar.cleanarchitecture.base.view.BaseViewHolder
import com.dushyant30suthar.cleanarchitecture.components.movieList.actions.MovieListAction
import com.dushyant30suthar.cleanarchitecture.components.movieList.viewHolder.MovieItemViewHolder


class MovieListViewHolderFactory {

    fun getViewHolderFor(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, MovieListAction> {
        return when (viewType) {

            R.layout.item_movie ->
                MovieItemViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_movie,
                        parent,
                        false
                    )
                )


            else -> throw IllegalArgumentException()
        }
    }

}