package com.soumik.photohub.features.gallery.domain.models
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
created by Soumik on 6/16/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

class PhotoList : ArrayList<PhotoListItem>()

@Parcelize
data class PhotoListItem(
    @SerializedName("alt_description")
    var altDescription: String?,
    @SerializedName("blur_hash")
    var blurHash: String?,
    @SerializedName("color")
    var color: String?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("links")
    var links: Links?,
    @SerializedName("promoted_at")
    var promotedAt: String?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("urls")
    var urls: Urls?,
    @SerializedName("width")
    var width: Int?
) : Parcelable

@Parcelize
data class Links(
    @SerializedName("download")
    var download: String?,
    @SerializedName("download_location")
    var downloadLocation: String?,
    @SerializedName("html")
    var html: String?,
    @SerializedName("self")
    var self: String?
) : Parcelable

@Parcelize
data class Urls(
    @SerializedName("full")
    var full: String?,
    @SerializedName("raw")
    var raw: String?,
    @SerializedName("regular")
    var regular: String?,
    @SerializedName("small")
    var small: String?,
    @SerializedName("small_s3")
    var smallS3: String?,
    @SerializedName("thumb")
    var thumb: String?
) : Parcelable