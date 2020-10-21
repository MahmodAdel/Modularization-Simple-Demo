package com.example.photos.base

import com.example.photos.ui.PhotosFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PhotosFragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMoviesListFragment(): PhotosFragment

}