package com.check.ui.base.util

import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import androidx.compose.ui.graphics.Color
import com.check.designsystem.Constants.TimberTag
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import timber.log.Timber
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.security.SecureRandom
import kotlin.random.Random

const val MEDIA_IMAGE_TYPE = "image"
const val MEDIA_VIDEO_TYPE = "video"
const val MP4_EXTENSION = ".mp4"

fun getParameterRoute(route: String, resource: String?) = "${route}/${resource}"
fun getParameterRoutes(route: String, vararg resources: String?) = buildString {
    append(route)
    resources.forEach { it?.let { append("/${it}") } }
}

fun getNavRoute(route: String, resource: String?) = "${route}/{${resource}}"
fun getNavRoutes(route: String, vararg resources: String?) = buildString {
    append(route)
    resources.forEach { it?.let{ append("/{${it}}") } }
}

fun getMediaTypeFromString(filePath: String): String? {
    val fileExtension = MimeTypeMap.getFileExtensionFromUrl(filePath)
    return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension)
}

fun getMediaTypeFromUri(context: Context, uri: Uri) = context.contentResolver.getType(uri)
fun isUriImage(uri: String) = getMediaTypeFromString(uri)?.contains("image")
fun isUriImage(context: Context, uri: Uri) = getMediaTypeFromUri(context, uri)?.contains("image")
fun isUriVideo(uri: String) = getMediaTypeFromString(uri)?.contains("video")
fun isUriVideo(context: Context, uri: Uri) = getMediaTypeFromUri(context, uri)?.contains("video")

fun decode(encodedUri: String): String? {
    return try {
        val decodedUri = URLDecoder.decode(encodedUri, StandardCharsets.UTF_8.toString())
        decodedUri
    } catch (e: UnsupportedEncodingException) {
        e.printStackTrace()
        null
    }
}

fun randomString(len: Int): String {
    val validChars = "abcdefghijklmnopqrstuvwxyz"
    val rnd = SecureRandom()
    val sb = StringBuilder(len)
    for (i in 0 until len) sb.append(validChars[rnd.nextInt(validChars.length)])
    return sb.toString()
}

fun printObjectParameters(obj: Any) {
    val properties = obj::class.java.declaredFields

    for (property in properties) {
        property.isAccessible = true
        val propertyName = property.name
        val propertyValue = property.get(obj)
        println("SHAFIE : $propertyName: $propertyValue")
        println("SHAFIE")
    }
}

inline fun <T> executePrintTimeElapsed(flag: String, calculation: () -> T): T {
    val startTime = System.nanoTime()
    val result = calculation()
    val stopTime = System.nanoTime()
    val elapsedTime = stopTime - startTime
    Timber.tag(TimberTag)
        .d("fun ${flag},time taken :${elapsedTime / 1e9}")
    return result
}

suspend fun <T> executeSuspendPrintTimeElapsed(flag: String, calculation: suspend () -> T): T {
    val startTime = System.nanoTime()
    val result = calculation()
    val stopTime = System.nanoTime()
    val elapsedTime = stopTime - startTime
    Timber.tag(TimberTag)
        .d("fun ${flag},time taken :${elapsedTime / 1e9}")
    return result
}

fun String.urlEncode(): String = URLEncoder.encode(this, "utf-8")

fun <T> getMoshiJson(obj: T, classToken: Class<T>): String {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(classToken).lenient()
    val userJson = jsonAdapter.toJson(obj).urlEncode()
    return userJson
}
fun <T> getObjFromMoshiJson(brandJson: String, classToken: Class<T>): T? {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(classToken).lenient()
    val obj = jsonAdapter.fromJson(brandJson)
    return obj
}
fun logDataSource(mesg:String) = Timber.tag("SHAFIE_DataSource").d(mesg)
fun logViewModel(mesg:String) = Timber.tag("SHAFIE_ViewModel").d(mesg)

fun randomColor(alpha: Int = 255) = Color(
    Random.nextInt(256),
    Random.nextInt(256),
    Random.nextInt(256),
    alpha = alpha
)