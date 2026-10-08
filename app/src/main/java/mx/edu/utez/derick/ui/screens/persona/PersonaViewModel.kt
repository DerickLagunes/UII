package mx.edu.utez.derick.ui.screens.persona

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import mx.edu.utez.derick.models.Persona

class PersonaViewModel: ViewModel() {
    private val _personas = MutableStateFlow<List<Persona>>(emptyList())
    val personas: StateFlow<List<Persona>> = _personas

    init{
        loadPersonas()
    }
    // Imaginar que esto es la consulta (Select) a la BD
    fun loadPersonas(){
        _personas.value = listOf(
            Persona(1, "Derick"),
            Persona(2, "Nancy")
        )
    }
    fun onPersonaClicked(p: Persona){
        Log.d("PersonaViewModel", "El viewModel ha sido notificado del un click en ${p.nombre}")
    }
}