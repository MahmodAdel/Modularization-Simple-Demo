package com.example.app.cache.photos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(posts: List<Photo>)

    @Query("SELECT * FROM photo")
    fun load(): LiveData<List<Photo>>
}
