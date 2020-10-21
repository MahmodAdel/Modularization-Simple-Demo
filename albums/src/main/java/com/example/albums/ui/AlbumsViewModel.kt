package com.example.albums.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.cache.Listener
import com.example.app.cache.albums.Album
import com.example.app.network.dataSource.AlbumsDataSource
import javax.inject.Inject

class AlbumsViewModel  @Inject constructor(val albumsDataSource: AlbumsDataSource) : ViewModel() {


    var albumsLiveData : MutableLiveData<List<Album>> = MutableLiveData()


    fun getAlbums(): LiveData<List<Album>> {

        return albumsDataSource.getAlbums(object :
            Listener<List<Album>> {
            override fun onResponse(response: List<Album>) {
                albumsLiveData.postValue(response)
            }
        })

    }

}