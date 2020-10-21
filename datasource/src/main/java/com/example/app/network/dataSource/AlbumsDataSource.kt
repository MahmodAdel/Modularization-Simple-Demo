package com.example.app.network.dataSource

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.app.cache.Listener
import com.example.app.cache.albums.Album
import com.example.app.cache.albums.AlbumPersist
import com.example.app.network.AlbumsApi
import com.example.app.network.NetworkClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AlbumsDataSource @Inject constructor(
    private val networkClient: NetworkClient<AlbumsApi>,
    val albumPersist: AlbumPersist
) {


    fun getAlbums(listener: Listener<List<Album>>): LiveData<List<Album>> {

        networkClient.getRetrofitService(AlbumsApi::class.java).getAlbums().enqueue(object :
            Callback<List<Album>> {
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                t.message?.let { Log.d("response_posts", it) }
            }

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                response.body()?.let {
                    listener.onResponse(response = it)
                    GlobalScope.launch {
                        albumPersist.save(it)
                    }
                }
            }
        })

        return albumPersist.load()

    }

}