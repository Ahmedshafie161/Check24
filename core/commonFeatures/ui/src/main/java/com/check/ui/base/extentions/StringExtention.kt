package com.check.ui.base.extentions

import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes

fun String.toHlsMediaItem()
        = MediaItem.Builder()
    .setUri(this)
    .setMimeType(MimeTypes.APPLICATION_M3U8)
    .build()

fun String.replacePlusWithSpace(): String {
    return this.replace('+', ' ')
}