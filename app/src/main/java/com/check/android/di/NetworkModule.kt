package com.check.android.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

 /*   @Provides
    fun provideBaseUrl() = "https://your.base.url/"

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient, converter: Converter.Factory) =
        RetrofitFactory.create(baseUrl, client, converter)*/
}