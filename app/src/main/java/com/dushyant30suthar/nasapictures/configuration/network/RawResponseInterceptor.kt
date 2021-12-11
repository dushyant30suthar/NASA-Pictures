package com.dushyant30suthar.nasapictures.configuration.network

import android.content.Context
import com.dushyant30suthar.nasapictures.R
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.BufferedReader
import java.io.IOException


class RawResponseInterceptor(private val mContext: Context) : Interceptor {

    private var mContentType = "application/json"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val uri = chain.request().url.toUri()
        if (uri.path.contains("api/cosmos/images/")) {

            try {
                val jsonString = mContext.resources
                    .openRawResource(R.raw.response)
                    .bufferedReader()
                    .use(BufferedReader::readText)

                val builder = Response.Builder()
                builder.request(chain.request())
                builder.protocol(Protocol.HTTP_1_0)
                builder.addHeader("content-type", mContentType)
                builder.body(
                    ResponseBody.create(
                        mContentType.toMediaTypeOrNull(),
                        jsonString.toByteArray()
                    )
                )
                builder.code(200)
                builder.message(jsonString)
                return builder.build()
            } catch (e: IOException) {

            }
        }
        return chain.proceed(chain.request())
    }

}
