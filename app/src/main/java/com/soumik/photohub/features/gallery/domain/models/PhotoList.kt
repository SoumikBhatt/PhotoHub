package com.soumik.photohub.features.gallery.domain.models
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


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
    @SerializedName("likes")
    var likes: String?,
    @SerializedName("promoted_at")
    var promotedAt: String?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("urls")
    var urls: Urls?,
    @SerializedName("width")
    var width: Int?,
    @SerializedName("user")
    var user: User?
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

@Parcelize
data class User(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean?,
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("for_hire")
    val forHire: Boolean?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("instagram_username")
    val instagramUsername: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("links")
    val links: LinksUser?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("portfolio_url")
    val portfolioUrl: String?,
    @SerializedName("profile_image")
    val profileImage: ProfileImage?,
    @SerializedName("social")
    val social: Social?,
    @SerializedName("total_collections")
    val totalCollections: Int?,
    @SerializedName("total_likes")
    val totalLikes: Int?,
    @SerializedName("total_photos")
    val totalPhotos: Int?,
    @SerializedName("twitter_username")
    val twitterUsername: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("username")
    val username: String?
) : Parcelable

@Parcelize
data class LinksUser(
    @SerializedName("followers")
    val followers: String?,
    @SerializedName("following")
    val following: String?,
    @SerializedName("html")
    val html: String?,
    @SerializedName("likes")
    val likes: String?,
    @SerializedName("photos")
    val photos: String?,
    @SerializedName("portfolio")
    val portfolio: String?,
    @SerializedName("self")
    val self: String?
) : Parcelable

@Parcelize
data class ProfileImage(
    @SerializedName("large")
    val large: String?,
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("small")
    val small: String?
) : Parcelable

@Parcelize
data class Social(
    @SerializedName("instagram_username")
    val instagramUsername: String?,
    @SerializedName("paypal_email")
    val paypalEmail: String?,
    @SerializedName("portfolio_url")
    val portfolioUrl: String?,
    @SerializedName("twitter_username")
    val twitterUsername: String?
) : Parcelable