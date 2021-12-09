package com.dushyant30suthar.nasapictures.components.cosmosImageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dushyant30suthar.nasapictures.R
import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.MovieListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.viewHolder.MovieItemViewHolder


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