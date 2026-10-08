package mx.edu.utez.derick.models

import androidx.annotation.DrawableRes

data class Cancion(
    val id: Int,
    val nombre: String,
    val genero: String,
    val duracion: String,
    val favorito: Boolean,
    @DrawableRes val album: Int?
)