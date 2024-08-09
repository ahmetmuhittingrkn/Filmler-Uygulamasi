package com.ahmetmuhittingurkan.filmleruygulamasi.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmetmuhittingurkan.filmleruygulamasi.data.entity.Filmler
import com.ahmetmuhittingurkan.filmleruygulamasi.data.repo.FilmlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var frepo:FilmlerRepository):ViewModel() {

    var filmlerListesi=MutableLiveData<List<Filmler>>()

    init{
        filmleriYukle()
    }

    fun filmleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            filmlerListesi.value=frepo.filmleriYukle()
        }
    }
}