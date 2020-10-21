package com.example.modularizationsimpledemo.base.builder

import androidx.lifecycle.ViewModel
import com.example.albums.ui.AlbumsViewModel
import com.example.modularizationsimpledemo.base.builder.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class AlbumsViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(AlbumsViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: AlbumsViewModel): ViewModel



}