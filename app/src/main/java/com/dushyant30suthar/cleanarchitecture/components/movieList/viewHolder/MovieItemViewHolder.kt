package com.dushyant30suthar.cleanarchitecture.components.movieList.viewHolder


import android.view.View
import com.dushyant30suthar.cleanarchitecture.base.view.BaseViewHolder
import com.dushyant30suthar.cleanarchitecture.components.movieList.actions.MovieListAction
import com.dushyant30suthar.cleanarchitecture.components.movieList.models.MovieModel


class MovieItemViewHolder(
    private val binding: Any,
) : BaseViewHolder<MovieModel, MovieListAction>(binding as View) {


    override fun bind(
        data: MovieModel,
        position: Int,
    ) {


    }

}