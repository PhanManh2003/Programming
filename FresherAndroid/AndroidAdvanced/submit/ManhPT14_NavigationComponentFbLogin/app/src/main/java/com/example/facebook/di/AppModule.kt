package com.example.facebook.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Nếu cần provide thêm các dependency khác
    // Repository tự inject qua @Inject constructor nên không cần provide ở đây
}