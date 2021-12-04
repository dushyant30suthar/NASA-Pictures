package com.dushyant30suthar.cleanarchitecture.components.movieList.models

import com.dushyant30suthar.cleanarchitecture.base.view.RecyclerViewItem

data class MovieModel(
    val movieName: String,
    val releaseYear: String,
    val ratings: String,
    override val viewType: Int
) : RecyclerViewItem
