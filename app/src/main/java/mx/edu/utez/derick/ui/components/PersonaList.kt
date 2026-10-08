package mx.edu.utez.derick.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.utez.derick.R
import mx.edu.utez.derick.models.Persona
import mx.edu.utez.derick.ui.theme.ProyectoTheme

@Composable
fun PersonaList(
    personas: List<Persona>,
    onItemClick: (Persona) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items= personas, key = {it.id}){ persona ->
            PersonaCard(
                persona = persona,
                onClick = {onItemClick(persona)}
            )
        }    } }
@Preview(showBackground = true)
@Composable
fun PersonaListPreview(){
    ProyectoTheme() {
        val lista = listOf(
            Persona(1,"Derick", apto = true),
            Persona(2, "Guillermo", edad = 20, img = R.drawable.logo),
            Persona(3,"Mateo", img = R.drawable.tools)
        )
        PersonaList(lista,{})
    }
}