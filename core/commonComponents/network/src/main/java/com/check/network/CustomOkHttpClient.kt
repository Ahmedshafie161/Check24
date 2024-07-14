package com.check.network

import CustomX509TrustManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun getOkHttpClientWithInterceptor() = OkHttpClient().newBuilder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .handleHttpSSLCertificate(CustomX509TrustManager)
    .build()