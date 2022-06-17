package com.compose.navigation.core.di

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class AppGlideModule : AppGlideModule() {

    private val byteSize: Long = 1024L
    private val cacheSize: Long = 20 * byteSize * byteSize

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setMemoryCache(LruResourceCache(cacheSize))
        builder.setDiskCache(InternalCacheDiskCacheFactory(context, cacheSize))
        builder.setDefaultRequestOptions(
            RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        )
    }
}
