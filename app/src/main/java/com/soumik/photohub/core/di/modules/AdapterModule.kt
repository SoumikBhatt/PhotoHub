package com.soumik.photohub.core.di.modules

import android.content.Context
import com.soumik.photohub.features.gallery.presentation.PhotoListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

/**
created by Soumik on 6/20/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

@Module
@InstallIn(ActivityComponent::class)
class AdapterModule {

    @Provides
    @ActivityScoped
    fun providePhotoListAdapter(@ActivityContext context: Context) : PhotoListAdapter {
        return PhotoListAdapter(context)
    }
}