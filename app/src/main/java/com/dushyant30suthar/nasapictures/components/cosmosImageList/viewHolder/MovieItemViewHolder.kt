package com.dushyant30suthar.nasapictures.components.cosmosImageList.viewHolder


import com.dushyant30suthar.nasapictures.base.view.BaseViewHolder
import com.dushyant30suthar.nasapictures.components.cosmosImageList.actions.MovieListAction
import com.dushyant30suthar.nasapictures.components.cosmosImageList.models.MovieModel
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