package com.dushyant30suthar.cleanarchitecture.components.movieList.viewModel

import com.dushyant30suthar.cleanarchitecture.base.viewModel.BaseViewModel
import com.dushyant30suthar.cleanarchitecture.components.movieList.mappers.MovieListRVItemsMapper
import com.dushyant30suthar.cleanarchitecture.domain.movieList.useCases.GetMovieListUseCase
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val movieListRVItemsMapper: MovieListRVItemsMapper
) : BaseViewModel() {


}