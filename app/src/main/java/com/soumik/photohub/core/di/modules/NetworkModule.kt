package com.soumik.photohub.core.di.modules

import android.content.Context
import com.soumik.photohub.core.utils.Constants
import com.soumik.photohub.core.utils.IConnectivity
import com.soumik.photohub.features.gallery.data.source.GalleryWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
created by Soumik on 6/15/2022
piyal.developer@gmail.com
copyright (c) 2022 Soumik Bhattacharjee. All rights reserved
 **/

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideGalleryWebService(retrofit: Retrofit): GalleryWebService =
        retrofit.create(GalleryWebService::class.java)

    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideCache(@ApplicationContext context: Context): Cache {
        val cacheSize = (5 * 1024 * 1024).toLong()
        return Cache(context.cacheDir, cacheSize)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache, connectivity: IConnectivity): OkHttpClient {
        return OkHttpClient
            .Builder()
            .cache(cache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (connectivity.hasInternetConnection()) {
                    /*
                       *  If there is Internet, get the cache that was stored 5 seconds ago.
                       *  If the cache is older than 5 seconds, then discard it,
                       *  and indicate an error in fetching the response.
                       *  The 'max-age' attribute is responsible for this behavior.
                       */
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5)
                        .header("Authorization", "Client-ID ${Constants.ACCESS_TOKEN}").build()
                } else {
                    /*
                        *  If there is no Internet, get the cache that was stored 7 days ago.
                        *  If the cache is older than 7 days, then discard it,
                        *  and indicate an error in fetching the response.
                        *  The 'max-stale' attribute is responsible for this behavior.
                        *  The 'only-if-cached' attribute indicates to not retrieve new data; fetch the cache only instead.
                        */
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                    ).build()
                }
                val response = chain.proceed(request)
                if (response.code() == 500) {
                    throw Exception(Constants.INTERNAL_SERVER_ERROR)
                } else if (response.code() == 404) {
                    throw Exception(Constants.URL_ERROR)
                }
                response
            }
            .connectTimeout(20000, TimeUnit.MILLISECONDS)
            .readTimeout(20000, TimeUnit.MILLISECONDS)
            .build()
    }


}