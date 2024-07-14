package com.check.network

import retrofit2.Retrofit
import javax.inject.Inject

interface ApiService {
    fun <T> buildWebService(webService: Class<T>): T
    fun <T> getData( page: Int): List<T>
}

class ApiServiceImp @Inject constructor(private val retrofit: Retrofit) : ApiService {
    override fun <T> buildWebService(webService: Class<T>): T {
        return retrofit.create(webService)
    }

    override fun <T> getData(page: Int): List<T> {
        TODO("Not yet implemented")
    }

}