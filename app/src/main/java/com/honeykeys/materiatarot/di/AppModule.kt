package com.honeykeys.materiatarot.di

import com.honeykeys.materiatarot.MateriaTarotApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesTarotCardRepository(app:MateriaTarotApp): TarotReadingRepository {
        return TarotReadingRepositoryImpl(app)
    }
}