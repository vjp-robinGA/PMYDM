package com.example.robin_proyecto_ut9.servicios

import com.example.robin_proyecto_ut9.modelo.Videojuego
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("videojuegos")
    suspend fun getVideojuegos(): Response<List<Videojuego>>

    @GET("videojuegos/{id}")
    suspend fun getVideojuego(@Path("id") id: Int): Response<Videojuego>

    @POST("videojuegos")
    suspend fun agregarVideojuego(@Body videojuego: Videojuego): Response<Videojuego>

    @DELETE("videojuegos/{id}")
    suspend fun eliminarVideojuego(@Path("id") id: Int): Response<Void>
}
