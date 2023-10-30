package com.example.breesmobileapp.di

import com.example.breesmobileapp.data.repository.FirebaseRepository
import com.example.breesmobileapp.data.repository.FirebaseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositroyModel {
    @Binds
    @Singleton
    abstract fun bindFirebaseRepository(repo: FirebaseRepositoryImpl): FirebaseRepository

//    @Binds
//    @Singleton
//    abstract fun bindApiRepository(repo: ApiRepositoryImpl): ApiRepository
}