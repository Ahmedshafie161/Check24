package com.check.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitFactory {

private const val BASE_CHECK_URL = "https://app.check24.de/"
    private var retrofit: Retrofit? = null
    private fun init(baseUrl: String, client: OkHttpClient, converter: Converter.Factory) =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(converter)
            .build()

    var gson = GsonBuilder().setLenient().create()
    fun <T> create(
        baseUrl: String = BASE_CHECK_URL,
        client: OkHttpClient = getOkHttpClientWithInterceptor(),
        converter: Converter.Factory = GsonConverterFactory.create(gson),
        apiService: Class<T>
    ): T {
        if (retrofit == null)
            retrofit = init(baseUrl, client, converter)
        return retrofit!!.create(apiService)
    }

}