package com.check.network

import android.util.Log
import io.grpc.ManagedChannel
import io.grpc.okhttp.OkHttpChannelBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import okhttp3.OkHttpClient
import timber.log.Timber
import java.security.SecureRandom
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
const val TimberTag = "SHAFIE"
fun OkHttpClient.Builder.handleHttpSSLCertificate(x509TrustManager: X509TrustManager): OkHttpClient.Builder {
    try {
        val trustAllCerts: Array<TrustManager> = arrayOf(x509TrustManager)
        val sc: SSLContext = SSLContext.getInstance("SSL")
        sc.init(null, trustAllCerts, SecureRandom())
        return this.sslSocketFactory(sc.socketFactory, trustAllCerts.first() as X509TrustManager)
    } catch (ignored: Exception) {
        Timber.tag(TimberTag).e("CERTIFICATE - %s", ignored.message.toString())
    }
    return this
}

fun OkHttpChannelBuilder.handleSSLCertificate(x509TrustManager: X509TrustManager): ManagedChannel? {
    try {
        val trustAllCerts: Array<TrustManager> = arrayOf(x509TrustManager)
        val sc: SSLContext = SSLContext.getInstance("SSL")
        sc.init(null, trustAllCerts, SecureRandom())
        this.sslSocketFactory(sc.socketFactory)
        this.hostnameVerifier { p0, p1 -> true }
        val result = this.executor(Dispatchers.IO.asExecutor()).build()
        return result
    } catch (e: Exception) {
        Log.e(TimberTag, "exception ${e.cause} ${e} ${e.printStackTrace()}")
    }
    return null
}
