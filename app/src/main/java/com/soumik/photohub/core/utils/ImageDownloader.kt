package com.soumik.photohub.core.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

/**
created by Soumik on 6/18/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

class ImageDownloader(private val mContext: Context) {

    companion object {
        private const val TAG = "ImageDownloader"
    }

    fun saveImageToStorage(
        imageUrl: String?,
        fileName: String? = "${System.currentTimeMillis()}.jpg"
    ): DownloadStatus {
        try {
            if (imageUrl != null) {
                val bitmap = convertUrlToBitmap(imageUrl)
                var fos: OutputStream? = null

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    mContext.contentResolver?.also { resolver ->
                        val contentValues = ContentValues().apply {
                            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                            put(
                                MediaStore.MediaColumns.RELATIVE_PATH,
                                Environment.DIRECTORY_PICTURES
                            )
                        }
                        val imageUri: Uri? = resolver.insert(
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            contentValues
                        )
                        fos = imageUri?.let { resolver.openOutputStream(it) }
                    }
                } else {
                    val imagesDir =
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                    val image = File(imagesDir, fileName!!)
                    fos = FileOutputStream(image)
                }
                fos?.use {
                    bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, it)
                }
                return DownloadStatus.SUCCESS
            } else return DownloadStatus.FAILED
        } catch (e: Exception) {
            Log.e(TAG, "saveImageToStorage: Exception: ${e.localizedMessage}", e)
            return DownloadStatus.FAILED
        }
    }

    private fun convertUrlToBitmap(imageUrl: String): Bitmap? {
        val url: URL = convertStringToUrl(imageUrl)!!
        val connection: HttpURLConnection?
        try {
            connection = url.openConnection() as HttpURLConnection
            connection.connect()
            val inputStream: InputStream = connection.inputStream
            val bufferedInputStream = BufferedInputStream(inputStream)
            return BitmapFactory.decodeStream(bufferedInputStream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * converting string to URL
     */
    private fun convertStringToUrl(string: String): URL? {
        try {
            return URL(string)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        return null
    }

    enum class DownloadStatus {
        SUCCESS,
        FAILED
    }

}


