package com.ahmetmuhittingurkan.filmleruygulamasi.data.repo

import com.ahmetmuhittingurkan.filmleruygulamasi.data.datasource.FilmlerDataSource
import com.ahmetmuhittingurkan.filmleruygulamasi.data.entity.Filmler

class FilmlerRepository(var fds:FilmlerDataSource) {

    suspend fun filmleriYukle(): List<Filmler> = fds.filmleriYukle()
}