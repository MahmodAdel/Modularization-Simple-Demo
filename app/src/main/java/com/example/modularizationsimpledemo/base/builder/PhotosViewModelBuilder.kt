package com.example.modularizationsimpledemo.base.builder

import androidx.lifecycle.ViewModel
import com.example.photos.ui.PhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PhotosViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: PhotosViewModel): ViewModel


}