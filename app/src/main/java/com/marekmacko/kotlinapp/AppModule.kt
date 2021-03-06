package com.marekmacko.kotlinapp

import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext() = context
}
