package mx.edu.utez.derick.models

import androidx.annotation.DrawableRes
import mx.edu.utez.derick.R

data class Persona(
    val id: Int,
    val nombre: String,
    val edad: Int = 19,
    val apto: Boolean = false,
    @DrawableRes val img: Int? = R.drawable.logogato
)