package com.example.accodechallenge

import com.example.accodechallenge.api.ListFlyService
import com.example.accodechallenge.api.ListFlyServiceWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient
            .Builder()
            // add the api token to each request
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val originalRequest = chain.request()
                    val requestWithHeader: Request = originalRequest
                        .newBuilder()
                        .header("Api-Token", BuildConfig.API_KEY)
                        .method(originalRequest.method, originalRequest.body)
                        .build()
                    return chain.proceed(requestWithHeader)
                }
            })

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            clientBuilder.addInterceptor(loggingInterceptor)
        }

        return clientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideListFlyService(retrofit: Retrofit): ListFlyService = retrofit.create(ListFlyService::class.java)

    @Provides
    @Singleton
    fun provideListFlyServiceWrapper(listFlyService: ListFlyService): ListFlyServiceWrapper =
        ListFlyServiceWrapper(listFlyService)
}