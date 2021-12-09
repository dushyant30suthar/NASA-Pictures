package com.dushyant30suthar.nasapictures.components.movieList.viewModel

import com.dushyant30suthar.nasapictures.base.viewModel.BaseViewModel
import com.dushyant30suthar.nasapictures.components.movieList.mappers.MovieListRVItemsMapper
import com.dushyant30suthar.nasapictures.domain.movieList.useCases.GetMovieListUseCase
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val movieListRVItemsMapper: MovieListRVItemsMapper
) : BaseViewModel() {


}