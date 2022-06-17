package com.soumik.photohub.features.gallery.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.soumik.photohub.core.utils.Constants
import com.soumik.photohub.features.gallery.domain.models.PhotoListItem
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
created by Soumik on 6/16/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

class GalleryListPagingSource @Inject constructor(private val galleryWebService: GalleryWebService) :
    PagingSource<Int, PhotoListItem>() {

    companion object {
        private const val STARTING_PAGE_NUMBER = 1
    }

    override fun getRefreshKey(state: PagingState<Int, PhotoListItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoListItem> {
        val page = params.key ?: STARTING_PAGE_NUMBER

        return try {
            val response = galleryWebService.getPhotos(page = page)
            if (response.isSuccessful && response.code() == 200 && response.body() != null) {
                val list = response.body()!!
                LoadResult.Page(
                    data = list,
                    nextKey = if (list.isNotEmpty()) page + 1 else null,
                    prevKey = if (page == STARTING_PAGE_NUMBER) null else page - 1
                )
            } else LoadResult.Error(Throwable(Constants.ERROR_MESSAGE))
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}