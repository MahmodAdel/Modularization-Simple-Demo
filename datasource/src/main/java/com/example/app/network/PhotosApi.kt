package com.example.app.network

import com.example.app.cache.photos.Photo
import retrofit2.Call
import retrofit2.http.GET

interface PhotosApi {

    @GET("photos")
    fun getPhotos(): Call<List<Photo>>
}