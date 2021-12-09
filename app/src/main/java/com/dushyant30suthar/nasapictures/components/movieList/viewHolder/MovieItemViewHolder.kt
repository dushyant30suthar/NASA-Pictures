package com.dushyant30suthar.nasapictures.components.movieList.viewHolder


import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.components.movieList.actions.MovieListAction
import com.dushyant30suthar.nasapictures.components.movieList.models.MovieModel
import com.dushyant30suthar.nasapictures.databinding.ItemMovieBinding


class MovieItemViewHolder(
    private val binding: ItemMovieBinding,
) : BaseViewHolder<MovieModel, MovieListAction>(binding.root) {


    override fun bind(
        data: MovieModel,
        position: Int,
    ) {


    }

}