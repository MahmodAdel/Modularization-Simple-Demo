package com.example.photos.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.cache.Listener
import com.example.app.cache.photos.Photo
import com.example.app.network.dataSource.PhotosDataSource
import javax.inject.Inject

class PhotosViewModel @Inject constructor(private val photosDataSource: PhotosDataSource) : ViewModel() {


    var photosLiveData: MutableLiveData<List<Photo>> = MutableLiveData()


    fun getPhotos(): LiveData<List<Photo>> {
        return photosDataSource.getPhotos(object :
            Listener<List<Photo>> {
            override fun onResponse(response: List<Photo>) {
                photosLiveData.postValue(response)
            }

        })

    }
}


