package mx.edu.utez.derick.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.utez.derick.R
import mx.edu.utez.derick.models.Cancion
import mx.edu.utez.derick.ui.theme.ProyectoTheme

@Composable
fun CancionList(
    canciones: List<Cancion>,
    onCancionClicked: (Cancion) -> Unit
){
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = canciones, key = { it.id } ){ cancion ->
            CancionCard(
                cancion,
                onClick = {onCancionClicked(cancion)}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CancionListPreview(){
    ProyectoTheme{
        val can1 = Cancion(1, "Selfless", "Rock/Pop", "3:12", true, R.drawable.logogato)
        val can2 = Cancion(2, "Lamento Boliviano", "Rock/Pop", "4:00", true, R.drawable.logo)
        val can3 = Cancion(3, "Neo Roneo", "Alternative", "2:30", true, R.drawable.tools)
        val lista = listOf(can1, can2, can3)
        CancionList(lista, {})
    }
}