package com.ahmetmuhittingurkan.filmleruygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmetmuhittingurkan.filmleruygulamasi.data.entity.Filmler
import com.ahmetmuhittingurkan.filmleruygulamasi.databinding.CardTasarimBinding
import com.ahmetmuhittingurkan.filmleruygulamasi.databinding.FragmentAnasayfaBinding
import com.ahmetmuhittingurkan.filmleruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext: Context,var filmlerListesi: List<Filmler>) : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film=filmlerListesi.get(position)
        val t =holder.tasarim

        val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${film.resim}"
        Glide.with(mContext).load(url).override(500, 750).into(t.imageViewFilm)

        t.textViewFiyat.text="${film.fiyat} ₺ "

        t.buttonSepet.setOnClickListener(){
            Snackbar.make(it,"${film.ad} sepetinize eklendi.",Snackbar.LENGTH_SHORT).show()
        }

        t.imageViewFilm.setOnClickListener(){
            val gecis=AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

}