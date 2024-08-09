package com.ahmetmuhittingurkan.filmleruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.ahmetmuhittingurkan.filmleruygulamasi.R
import com.ahmetmuhittingurkan.filmleruygulamasi.databinding.FragmentDetayBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)


        val bundle: DetayFragmentArgs by navArgs()
        val gelenFilm=bundle.film

        binding.filmNesnesi=gelenFilm

        val url="http://kasimadalan.pe.hu/filmler_yeni/resimler/${gelenFilm.resim}"
        Glide.with(this).load(url).override(500,750).into(binding.ivFilm)

        return binding.root

    }
}
