package com.example.modularizationsimpledemo.base.builder


import com.example.albums.base.AlbumsFragmentBuilder
import com.example.modularizationsimpledemo.ui.MainActivity
import com.example.photos.base.PhotosFragmentBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            AlbumsFragmentBuilder::class,
            PhotosFragmentBuilder::class,
            AlbumsViewModelBuilder::class,
            PhotosViewModelBuilder::class
        ]
    )

    internal abstract fun bindMainActivity(): MainActivity

}