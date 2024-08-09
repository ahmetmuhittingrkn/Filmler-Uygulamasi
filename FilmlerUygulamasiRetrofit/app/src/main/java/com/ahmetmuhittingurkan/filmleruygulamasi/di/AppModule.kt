package com.ahmetmuhittingurkan.filmleruygulamasi.di

import com.ahmetmuhittingurkan.filmleruygulamasi.data.datasource.FilmlerDataSource
import com.ahmetmuhittingurkan.filmleruygulamasi.data.repo.FilmlerRepository
import com.ahmetmuhittingurkan.filmleruygulamasi.retrofit.ApiUtils
import com.ahmetmuhittingurkan.filmleruygulamasi.retrofit.FilmlerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFilmlerDataSource(fdao:FilmlerDao): FilmlerDataSource{
        return FilmlerDataSource(fdao)
    }

    @Provides
    @Singleton
    fun provideFilmlerRepository(fds:FilmlerDataSource): FilmlerRepository{
        return FilmlerRepository(fds)
    }

    @Provides
    @Singleton
    fun provideFilmlerDao(): FilmlerDao{
        return ApiUtils.getFilmlerDao()
    }

}