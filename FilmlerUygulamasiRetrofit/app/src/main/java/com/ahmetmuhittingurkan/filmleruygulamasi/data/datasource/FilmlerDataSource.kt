package com.ahmetmuhittingurkan.filmleruygulamasi.data.datasource

import com.ahmetmuhittingurkan.filmleruygulamasi.data.entity.Filmler
import com.ahmetmuhittingurkan.filmleruygulamasi.retrofit.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var fdao:FilmlerDao) {

    suspend fun filmleriYukle(): List<Filmler> =
        withContext(Dispatchers.IO){

            return@withContext fdao.filmleriYukle().filmler
        }
}