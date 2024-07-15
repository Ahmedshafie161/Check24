package com.check.ui.base.extentions

import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.toHlsMediaItem()
        = MediaItem.Builder()
    .setUri(this)
    .setMimeType(MimeTypes.APPLICATION_M3U8)
    .build()

fun String.replacePlusWithSpace(): String {
    return this.replace('+', ' ')
}
fun Long.toFormattedDateString(): String {
    val date = Date(this)
    val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    return formatter.format(date)
}