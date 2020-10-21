package com.example.app.cache.photos

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.app.cache.CacheInterface
import com.example.app.cache.MainDatabase
import javax.inject.Inject

class PhotoPersist @Inject constructor(val context: Context) :
    CacheInterface<Photo> {

    var photoDao: PhotoDao = MainDatabase.getDatabase(context).photoDao()

    @WorkerThread
    override suspend fun save(items: List<Photo>) {
        photoDao.save(items)
    }

    override fun load(): LiveData<List<Photo>> {
        return photoDao.load()
    }


}