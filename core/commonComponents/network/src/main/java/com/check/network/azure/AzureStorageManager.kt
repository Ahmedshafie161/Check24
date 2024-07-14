package com.check.network.azure

import android.content.Context
import android.net.Uri
import com.check.network.TimberTag
import com.microsoft.azure.storage.CloudStorageAccount
import com.microsoft.azure.storage.blob.CloudBlobContainer
import com.microsoft.azure.storage.blob.CloudBlockBlob
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.InputStream
import java.io.OutputStream
import java.net.URI
import java.security.SecureRandom
import java.util.LinkedList
import javax.inject.Inject


@ViewModelScoped
class AzureStorageManager @Inject constructor(@ApplicationContext val context: Context) {
    companion object {
        private const val ACCOUNT_NAME = ""
        private const val base_url = ""
        private const val SAS_KEY = ""
        const val storageConnectionWithSASKeyString = ""
        lateinit var uploadUrl: String
    }

    @get:Throws(Exception::class)
    private val container: CloudBlobContainer
        get() {
            // Retrieve storage account from connection-string.
            val storageAccount =
                CloudStorageAccount.parse(storageConnectionWithSASKeyString)
            // Create the blob client.
            val blobClient = storageAccount.createCloudBlobClient()
            // Get a reference to a container.
            // The container name must be lower case
            return blobClient.getContainerReference("videos" /*+ UUID.randomUUID().toString().replace("-", "")*/)
        }

    @Throws(Exception::class)
    suspend fun uploadMedia(
        contentType: String,
        uri: Uri,
        extension: String,
        onUploadCompleted: suspend () -> Unit = {}
    ) {
        Timber.tag(TimberTag).d("upload URL : $uploadUrl ")
        try {
            val resolver = context.contentResolver
            withContext(Dispatchers.IO) {
                resolver.openInputStream(uri)?.use { inputStream ->
                    uploadMediaToBlob(contentType, inputStream, inputStream.available(), extension)
                }
            }
        } catch (e: Exception) {
            Timber.tag(TimberTag).e(e)
            throw e
        }
        onUploadCompleted()
    }


    @Throws(Exception::class)
    private fun uploadMediaToContainer(
        contentType: String,
        inputStream: InputStream,
        imageLength: Int,
        extension: String
    ): String {
        val container = container
        container.createIfNotExists()
        // file name
        val imageName = randomString(10) + extension
        val imageBlob = container.getBlockBlobReference(imageName)
        imageBlob.properties.contentType = contentType
        inputStream.use { inputStream ->
            imageBlob.upload(inputStream, imageLength.toLong())
        }
        return imageName
    }

    @Throws(Exception::class)
    private fun uploadMediaToBlob(
        contentType: String,
        inputStream: InputStream,
        imageLength: Int,
        extension: String
    ): String {
        val cloudBlob = CloudBlockBlob(URI.create(uploadUrl))
        val imageName = randomString(10) + extension
        inputStream.use { inputStream -> cloudBlob.upload(inputStream, imageLength.toLong()) }
        return imageName
    }

    @Throws(Exception::class)
    fun listImages(): Array<String> {
        val container = container
        val blobs = container.listBlobs()
        val blobNames = LinkedList<String>()
        for (blob in blobs) {
            blobNames.add((blob as CloudBlockBlob).name)
            Timber.tag(TimberTag).d("listImages: " + blob.name + " ")
        }
        return blobNames.toTypedArray()
    }

    @Throws(Exception::class)
    fun getImage(name: String?, imageStream: OutputStream?, imageLength: Long) {
        var imageLength = imageLength
        val container = container
        val blob = container.getBlockBlobReference(name)
        if (blob.exists()) {
            blob.downloadAttributes()
            imageLength = blob.properties.length
            blob.download(imageStream)
        }
    }

}
fun randomString(len: Int): String {
    val validChars = "abcdefghijklmnopqrstuvwxyz"
    val rnd = SecureRandom()
    val sb = StringBuilder(len)
    for (i in 0 until len) sb.append(validChars[rnd.nextInt(validChars.length)])
    return sb.toString()
}
