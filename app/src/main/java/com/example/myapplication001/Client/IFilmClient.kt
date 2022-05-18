package com.example.myapplication001.Client

import com.example.myapplication001.model.Film
import retrofit2.http.GET
import retrofit2.http.Header

interface IFilmClient {
    @GET("3/trending/movie/week?")
    api_key=b9b4b46cf58a8e9941f2d4a03c514ad7
    fun getBreeds (): List<Film>
}