package com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases

import com.dushyant30suthar.nasapictures.base.rx.SingleUseCase
import com.dushyant30suthar.nasapictures.data.cosmosImageList.repository.CosmosImageListRepository
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import io.reactivex.Single
import javax.inject.Inject

class GetCosmosImageListUseCase @Inject constructor(private val cosmosImageListRepository: CosmosImageListRepository) :
    SingleUseCase<List<CosmosImageEntity>, Unit> {

    override fun execute(param: Unit): Single<List<CosmosImageEntity>> =
        cosmosImageListRepository.getCosmosImageList()

}