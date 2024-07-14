package com.check.network.grpc

import CustomX509TrustManager
import com.check.database.SharedPrefersManager
import com.check.network.handleSSLCertificate
import io.grpc.ManagedChannel
import io.grpc.okhttp.OkHttpChannelBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.UUID
import javax.inject.Inject

const val defaultPort = 530
const val scheme = "https"

class GreeterRCP @Inject constructor(sharedPrefersManager: SharedPrefersManager) {
    private val okHttpChannelBuilder: OkHttpChannelBuilder = OkHttpChannelBuilder
        .forAddress("", 530)
//        .keepAliveTimeout(60L, TimeUnit.MINUTES)
        .useTransportSecurity()

    private val channel: ManagedChannel by lazy {
        okHttpChannelBuilder.handleSSLCertificate(CustomX509TrustManager)!!
    }

    private val blockingStub by lazy { (channel) }

    private val _token by lazy { MutableStateFlow(sharedPrefersManager.getToken()) }
    private val token = _token.asSharedFlow()

    private val nameSpace by lazy { MutableStateFlow(sharedPrefersManager.getNameSpace()) }
    private val uploadRequestName = UUID.randomUUID().toString()

}