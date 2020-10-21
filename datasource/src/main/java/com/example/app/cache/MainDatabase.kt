package com.example.app.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app.cache.albums.Album
import com.example.app.cache.albums.AlbumDao
import com.example.app.cache.photos.Photo
import com.example.app.cache.photos.PhotoDao

@Database(entities = [Album::class, Photo::class], version = 1)
abstract class MainDatabase : RoomDatabase() {


    abstract fun postDao(): AlbumDao

    abstract fun photoDao(): PhotoDao


    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "MainDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}