package com.check.ui.base.util

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri
import androidx.compose.runtime.Composable
import com.check.core.commonFeatures.ui.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getThumbnailFromVideoGallery(
    context: Context,
    uri: Uri,
    frameTime: Long = 100
): Bitmap? {
    val mediaMetadataRetriever = MediaMetadataRetriever()
    return try {
        mediaMetadataRetriever.setDataSource(context, uri)
        withContext(Dispatchers.IO) {
            mediaMetadataRetriever.getFrameAtTime(frameTime) // time in Micros
        }
    } catch (e: Exception) {
        if (BuildConfig.DEBUG) {
            e.printStackTrace()
        }
        null
    } finally {
        mediaMetadataRetriever.release()
    }
}

fun <T : Any> executeNonNullable(data: T?, calculation: (T) -> Unit) {
    data?.let { calculation(it) }
}

@Composable
fun <T : Any> ExecCompNonNull(data: T?, calculation: @Composable (T) -> Unit) {
    data?.let { calculation(it) }
}
