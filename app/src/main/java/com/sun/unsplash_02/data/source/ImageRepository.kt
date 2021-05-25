package com.sun.unsplash_02.data.source

import com.sun.unsplash_02.data.model.Collection
import com.sun.unsplash_02.data.model.Image
import com.sun.unsplash_02.data.source.remote.ImageRemoteDataResource
import com.sun.unsplash_02.data.source.remote.OnFetchDataJsonListener

class ImageRepository private constructor(private val remote: ImageDataSource.Remote) {

    fun getCollections(listener: OnFetchDataJsonListener<MutableList<Collection>>) =
        remote.getListCollections(listener)

    fun getImages(listener: OnFetchDataJsonListener<MutableList<Image>>, page: Int) =
        remote.getListImages(listener, page)

    companion object {
        @Volatile
        private var instance: ImageRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: ImageRepository(ImageRemoteDataResource.getInstance()).also {
                instance = it
            }
        }
    }
}
