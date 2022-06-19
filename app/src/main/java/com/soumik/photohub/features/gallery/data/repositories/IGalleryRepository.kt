package com.soumik.photohub.features.gallery.data.repositories

import androidx.paging.PagingData
import com.soumik.photohub.features.gallery.domain.models.PhotoListItem
import kotlinx.coroutines.flow.Flow

/**
created by Soumik on 6/16/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

interface IGalleryRepository {
    fun getPhotos(page: Int): Flow<PagingData<PhotoListItem>>
}