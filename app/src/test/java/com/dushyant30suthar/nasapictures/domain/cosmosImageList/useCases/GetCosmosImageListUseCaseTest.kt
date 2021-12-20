package com.dushyant30suthar.nasapictures.domain.cosmosImageList.useCases

import com.dushyant30suthar.nasapictures.cosmosImageEntity
import com.dushyant30suthar.nasapictures.cosmosImageEntityWithEmptyValues
import com.dushyant30suthar.nasapictures.data.cosmosImageList.repository.CosmosImageListRepository
import com.dushyant30suthar.nasapictures.data.cosmosImageList.services.CosmosService
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/*
* I never ever wrote test cases in production. Having hard time getting into this as I couldn't collect much about
* structuring or a system to call it as a TestSystem.
*
* I just assume there would be some configuration classes which could get me the unMocked version of classes
* upon which we can perform operations. For example we are not using the retrofit configuration that we just have
* in our main code. We are testing use case not the actual code.
*
* Writing standalone methods doesn't really feels good. But anyways this is what I could collect
* as understandings.*/

class GetCosmosImageListUseCaseTest {

    @get:Rule
    val mockWebServer = MockWebServer()

    private var cosmosService: CosmosService? = null

    private lateinit var cosmosImageListRepository: CosmosImageListRepository

    private val getCosmosImageListUseCase by lazy {
        GetCosmosImageListUseCase(
            cosmosImageListRepository
        )
    }

    @Before
    fun setUp() {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        cosmosService = retrofit.create(CosmosService::class.java)
        cosmosImageListRepository = CosmosImageListRepository(cosmosService!!)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    /*
    * This test represents that nonNull Values are getting parsed correctly.*/
    @Test
    fun `should fetch cosmosImageList correctly`() {
        mockWebServer.enqueue(MockResponse().setBody(getResponse("response")))

        val expectedResponse = listOf(cosmosImageEntity())

        getCosmosImageListUseCase.execute(Unit)
            .observeOn(Schedulers.trampoline())
            .subscribeOn(Schedulers.trampoline())
            .test()
            .assertValue(expectedResponse)


        val request = mockWebServer.takeRequest()

        /*
        * By using request object,
        * Here we can print the parameter that we have received from the client.*/
    }


    @Test
    fun `should give cosmosImageList correctly even though some values are null`() {
        mockWebServer.enqueue(MockResponse().setBody(getResponse("response_with_null_values")))

        val expectedResponse = listOf(cosmosImageEntityWithEmptyValues())

        getCosmosImageListUseCase.execute(Unit)
            .observeOn(Schedulers.trampoline())
            .subscribeOn(Schedulers.trampoline())
            .test()
            .assertValue(expectedResponse)
        /*.subscribe(
            { response ->

                assertEquals(expectedResponse.toString(), response.toString())
            },
            { exception ->
                when (exception) {
                    is HttpException -> assertThrows(HttpException::class.java) { throw exception }
                    is JsonSyntaxException -> assertThrows(HttpException::class.java) { throw exception }
                }
            })*/

        val request = mockWebServer.takeRequest()

        /*
        * By using request object,
        * Here we can print the parameter that we have received from the client.*/
    }


    private fun getResponse(fileName: String): String {
        return GetCosmosImageListUseCaseTest::class.java.getResourceAsStream("$fileName.txt")
            .bufferedReader().use { it.readText() }
    }

}