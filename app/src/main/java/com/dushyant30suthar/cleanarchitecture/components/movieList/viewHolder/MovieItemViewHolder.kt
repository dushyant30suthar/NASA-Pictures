package com.dushyant30suthar.cleanarchitecture.components.movieList.viewHolder


import com.dushyant30suthar.cleanarchitecture.base.view.BaseViewHolder
import com.dushyant30suthar.cleanarchitecture.components.movieList.actions.MovieListAction
import com.dushyant30suthar.cleanarchitecture.components.movieList.models.MovieModel
import com.dushyant30suthar.cleanarchitecture.databinding.ItemMovieBinding


class MovieItemViewHolder(
    private val binding: ItemMovieBinding,
) : BaseViewHolder<MovieModel, MovieListAction>(binding.root) {


    override fun bind(
        data: MovieModel,
        position: Int,
    ) {


    }

}