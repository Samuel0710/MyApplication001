package com.example.myapplication001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication001.databinding.ActivityMainBinding
import com.example.myapplication001.model.mockFilm

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val filmListAdapter = FilmeItemAdapter()

        filmListAdapter.onClickListener={filmID ->
            goToFilmDetails(filmID)

        }

        binding.recyclerTeste.adapter = filmListAdapter

        filmListAdapter.submitList(mockFilm())
    }
    private fun goToFilmDetails(filmId: Int ){

        val intent= Intent(this,FilmDetailsActivity::class.java)
        intent.putExtra("filmID",filmId)
        startActivity(intent)
    }
}
