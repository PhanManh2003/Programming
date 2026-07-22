package com.example.hiltcrypto.di

import com.example.hiltcrypto.data.repository.CryptoRepository
import com.example.hiltcrypto.data.repository.CryptoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindCryptoRepository(
        impl: CryptoRepositoryImpl
    ): CryptoRepository
}