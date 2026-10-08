package mx.edu.utez.derick.ui.screens.cancion

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import mx.edu.utez.derick.R
import mx.edu.utez.derick.models.Cancion

class CancionViewModel: ViewModel() {

    private val _canciones = MutableStateFlow<List<Cancion>>(emptyList())
    val canciones: StateFlow<List<Cancion>> = _canciones

    init {
        loadCanciones()
    }

    fun loadCanciones(){
        _canciones.value = listOf(
            Cancion(1, "Selfless", "Rock/Pop", "3:12", true, R.drawable.logogato),
            Cancion(2, "Lamento Boliviano", "Rock/Pop", "4:00", true, R.drawable.logo),
            Cancion(3, "Neo Roneo", "Alternative", "2:30", true, R.drawable.tools)
        )
    }

    fun onCancionClicked(can: Cancion){
        Log.d("CancionViewModel", "El viewModel ha sido notificado del click en ${can.nombre}")
    }

}