package com.example.myapplication001

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication001.databinding.ActivityFilmeDetailsBinding
import com.example.myapplication001.model.Film
import com.example.myapplication001.model.mockFilm

class FilmDetailsActivity: AppCompatActivity () {

    private val binding by lazy {

        ActivityFilmeDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val filmId = intent.getIntExtra("filmID",0)

        val filmSelected = mockFilm().find { film -> film.id == filmId }

    }

    private fun setData(filmSelected: Film?){
        filmSelected?.let { film->
            binding.batmanTitle2.text = film.original_title
            binding.batmanNota1.text = film.poster_path
            binding.resumeSinopse2.text = film.title

        }
    }

}