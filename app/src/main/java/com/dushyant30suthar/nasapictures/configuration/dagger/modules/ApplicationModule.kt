package com.dushyant30suthar.nasapictures.configuration.dagger.modules

import android.app.Application
import android.content.Context
import com.dushyant30suthar.nasapictures.BuildConfig
import com.dushyant30suthar.nasapictures.configuration.dagger.annotations.ApplicationContext
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
object ApplicationModule {

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()


    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(application: Application): Context = application.applicationContext


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(900, TimeUnit.MILLISECONDS)
            .readTimeout(60000, TimeUnit.MILLISECONDS)
            .writeTimeout(60000, TimeUnit.MILLISECONDS)
            /*.addInterceptor(AuthTokenInterceptor(context))*/
            .apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(
                        HttpLoggingInterceptor()
                            .also { it.level = HttpLoggingInterceptor.Level.BODY }
                    )
                }
            }.build()


    @Provides
    @Singleton
    fun provideRetroFit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}