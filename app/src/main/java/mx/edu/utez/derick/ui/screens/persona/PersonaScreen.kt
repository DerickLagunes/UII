package mx.edu.utez.derick.ui.screens.persona

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.edu.utez.derick.ui.components.PersonaList

@Composable
fun PersonaScreen(
    viewModel: PersonaViewModel = viewModel(),
    navController: NavController
) {
    //Digamos que estamos sacando de la BDd
    val personas by viewModel.personas.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Text("Personas aptas para el puesto:", style = MaterialTheme.typography.titleLarge )
        Spacer(modifier = Modifier.height(20.dp))
        PersonaList(
            personas = personas,
            onItemClick = viewModel::onPersonaClicked
        )
    }
}