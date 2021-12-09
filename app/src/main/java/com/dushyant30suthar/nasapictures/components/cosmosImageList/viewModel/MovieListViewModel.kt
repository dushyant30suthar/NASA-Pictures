package com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel

import com.dushyant30suthar.nasapictures.base.viewModel.BaseViewModel
import com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers.MovieListRVItemsMapper
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases.GetMovieListUseCase
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val movieListRVItemsMapper: MovieListRVItemsMapper
) : BaseViewModel() {


}