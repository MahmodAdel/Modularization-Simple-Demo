package com.example.app.cache.albums

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.app.cache.CacheInterface
import com.example.app.cache.MainDatabase
import javax.inject.Inject

class AlbumPersist @Inject constructor(val context: Context) :
    CacheInterface<Album> {

    private var albumDao: AlbumDao = MainDatabase.getDatabase(context).postDao()

    @WorkerThread
    override suspend fun save(items: List<Album>) {
        albumDao.save(items)
    }

    override  fun load(): LiveData<List<Album>> {
        return albumDao.load()
    }

}