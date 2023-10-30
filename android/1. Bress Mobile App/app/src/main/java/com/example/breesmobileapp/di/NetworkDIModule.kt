package com.example.breesmobileapp.di

import com.example.breesmobileapp.data.remote.api.ApiRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkDIModule {
    @Singleton
    @Provides
    fun provideBaseURL(): String = "https://URLBASE"

    @Singleton
    @Provides
    fun provideInterceptor(): Interceptor {
        return ApiRetrofit.HeaderInterceptor
    }
}