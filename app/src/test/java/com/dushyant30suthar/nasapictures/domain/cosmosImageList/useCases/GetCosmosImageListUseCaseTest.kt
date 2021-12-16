package com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases

import com.dushyant30suthar.nasapictures.data.cosmosImageList.services.CosmosService
import com.dushyant30suthar.nasapictures.domain.cosmosImageList.entities.CosmosImageEntity
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.TestSubscriber
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.Calls
import retrofit2.mock.MockRetrofit


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


    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://www.google.com").build()
    private val mockRetrofit = MockRetrofit.Builder(retrofit).build()
    val cosmosService = mockRetrofit.create(CosmosService::class.java)

    @Test
    fun execute() {

        val subscriber = TestSubscriber<List<CosmosImageEntity>>()

        val response = Calls.response(getExpectedResponse())

        cosmosService.returningResponse(Calls.response(getExpectedResponse()).execute().body())
            .getCosmosImageList()
            .observeOn(Schedulers.trampoline())
            .subscribeOn(Schedulers.trampoline())
            .subscribe({ assert(true) }, { assert(false) })
    }

    private fun onCosmosImageListSuccess(it: List<CosmosImageEntity>) {
        assertEquals(26, it.size)
    }

    private fun onCosmosImageListError(e: Throwable) {

    }


    private fun getExpectedResponse(): String {
        return GetCosmosImageListUseCaseTest::class.java.getResourceAsStream("response.txt")
            .bufferedReader().use { it.readText() }
    }

}