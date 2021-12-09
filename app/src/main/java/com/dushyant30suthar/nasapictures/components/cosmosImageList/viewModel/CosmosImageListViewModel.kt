package com.dushyant30suthar.nasapictures.components.cosmosImageList.viewModel

import com.dushyant30suthar.nasapictures.base.viewModel.BaseViewModel
import com.dushyant30suthar.nasapictures.components.cosmosImageList.mappers.CosmosImageListRVItemsMapper
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases.GetCosmosImageListUseCase
import javax.inject.Inject

class CosmosImageListViewModel @Inject constructor(
    private val getCosmosImageListUseCase: GetCosmosImageListUseCase,
    private val cosmosImageListRVItemsMapper: CosmosImageListRVItemsMapper
) : BaseViewModel() {


}