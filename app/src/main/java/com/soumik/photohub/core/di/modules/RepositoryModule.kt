package com.soumik.photohub.core.di.modules

import com.soumik.photohub.features.gallery.data.repositories.GalleryRepositoryImpl
import com.soumik.photohub.features.gallery.data.repositories.IGalleryRepository
import com.soumik.photohub.features.gallery.data.source.GalleryWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
created by Soumik on 6/16/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGalleryRepositoryImplementation(galleryWebService: GalleryWebService) : IGalleryRepository {
        return GalleryRepositoryImpl(galleryWebService)
    }
}