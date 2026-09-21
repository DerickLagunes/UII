package mx.edu.utez.derick.ui.screens.conversor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ConversorScreen(
    modifier: Modifier = Modifier,
    viewModel: ConversorViewModel = viewModel() // Inyección del ViewModel
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Título
        Text(
            text = "Conversor de Divisas",
            style = MaterialTheme.typography.headlineMedium
        )

        // 2. Input numérico (Lee el valor del ViewModel y le notifica los cambios)
        OutlinedTextField(
            value = viewModel.usdInput,
            onValueChange = { viewModel.onUsdInputChanged(it) },
            label = { Text("Cantidad en USD") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // 3. Botón de cálculo (Delega la ejecución al ViewModel)
        Button(
            onClick = { viewModel.convertirDivisa() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convertir a MXN")
        }

        // 4. Texto de resultado (Lee el resultado del ViewModel)
        Text(
            text = "Total: $${viewModel.resultadoMxn} MXN",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}