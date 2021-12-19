package com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases

import com.dushyant30suthar.nasapictures.data.cosmosImageList.repository.CosmosImageListRepository
import io.reactivex.Single
import org.junit.Test


/*
* I never ever wrote test cases in production. Having hard time getting into this as I couldn't collect much about
* structuring or a system to call it as a TestSystem.
*
* I just assume there would be some configuration classes which would get me the unMocked version of classes
* upon which we can perform operations.
*
* Writing standalone methods doesn't really feels good. But anyways this is what I could collect
* as understandings within hours.*/

class GetCosmosImageListUseCaseTest {


    private val cosmosImageListRepository = mock<CosmosImageListRepository>()

    private val getCosmosImageListUseCase by lazy {
        GetCosmosImageListUseCase(
            cosmosImageListRepository
        )
    }

    @Test
    fun testGetCosmosImageListUseCase_Completed() {

        whenever(cosmosImageListRepository.getCosmosImageList())
            .thenReturn(Single.just(emptyList()))

        getCosmosImageListUseCase.execute(Unit)
            .test()
            .assertComplete()
    }

    @Test
    fun testGetCosmosImageListUseCase_Error() {

        val response = Throwable("Error response")
        whenever(cosmosImageListRepository.getCosmosImageList())
            .thenReturn(Single.error(response))

        getCosmosImageListUseCase.execute(Unit)
            .test()
            .assertError(response)

    }

    @Test
    fun testGetCosmosImageListUseCase_Response() {
        val response = arrayListOf(cosmosImageEntity())

        val expectedList = arrayListOf(cosmosImageEntity())

        whenever(cosmosImageListRepository.getCosmosImageList())
            .thenReturn(Single.just(response))


        getCosmosImageListUseCase.execute(Unit)
            .test()
            .assertValue(expectedList)
    }

}