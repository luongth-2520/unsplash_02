package com.sun.unsplash_02.utils

import com.sun.unsplash_02.BuildConfig

object Constants {
    private const val API_KEY = "client_id=${BuildConfig.API_KEY}"
    private const val BASE_URL = "https://api.unsplash.com"
    private const val COLLECTIONS = "/collections"
    private const val PHOTOS = "/photos"
    const val URL_COLLECTIONS = "$BASE_URL$COLLECTIONS?$API_KEY&page=8"
    const val URL_PHOTOS = "$BASE_URL$PHOTOS?$API_KEY&page="
}
