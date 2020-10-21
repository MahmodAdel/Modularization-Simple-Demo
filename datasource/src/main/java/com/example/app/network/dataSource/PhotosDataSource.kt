package com.example.app.network.dataSource

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.app.cache.Listener
import com.example.app.cache.photos.Photo
import com.example.app.cache.photos.PhotoPersist
import com.example.app.network.NetworkClient
import com.example.app.network.PhotosApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PhotosDataSource @Inject constructor(val networkClient : NetworkClient<PhotosApi>, val photoPersist : PhotoPersist) {


    fun getPhotos(listener: Listener<List<Photo>>): LiveData<List<Photo>> {

        networkClient.getRetrofitService(PhotosApi::class.java).getPhotos().enqueue(object :
            Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                t.message?.let { Log.d("response_posts", it) }
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                response.body()?.let {
                    listener.onResponse(response = it)
                    GlobalScope.launch {
                        photoPersist.save(it)
                    }
                }
            }
        })

        return photoPersist.load()
    }

}