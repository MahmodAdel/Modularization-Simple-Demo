package com.example.modularizationsimpledemo.base

import com.example.modularizationsimpledemo.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
public interface MainActivityComponent:AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}