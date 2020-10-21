package com.example.albums.base

import com.example.albums.ui.AlbumsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AlbumsFragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMoviesListFragment(): AlbumsFragment

}