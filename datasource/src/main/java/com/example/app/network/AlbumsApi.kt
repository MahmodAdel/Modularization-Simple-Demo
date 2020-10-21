package com.example.app.network

import com.example.app.cache.albums.Album
import retrofit2.Call
import retrofit2.http.GET

interface AlbumsApi {

    @GET("albums")
    fun getAlbums(): Call<List<Album>>
}