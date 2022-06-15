package com.soumik.photohub.features.gallery.data.source

import com.soumik.photohub.core.utils.Constants
import com.soumik.photohub.features.gallery.domain.models.PhotoList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
created by Soumik on 6/15/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

interface GalleryWebService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int? = Constants.INITIALLY_LOADED_ITEM_COUNT
    ) : Response<PhotoList>

}