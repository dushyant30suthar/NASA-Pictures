package com.dushyant30suthar.cleanarchitecture.configuration.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthTokenInterceptor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "")
            .addHeader("Content-Type", "application/json")
            .build()


        return chain.proceed(request)
    }

}