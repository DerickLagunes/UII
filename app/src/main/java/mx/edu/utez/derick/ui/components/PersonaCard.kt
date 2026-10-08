package mx.edu.utez.derick.ui.components

import android.R.attr.contentDescription
import android.R.attr.text
import android.R.attr.theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.derick.R
import mx.edu.utez.derick.models.Persona
import mx.edu.utez.derick.ui.theme.ProyectoTheme

@Composable
fun PersonaCard(
    persona: Persona,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier=Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(persona.img ?: R.drawable.gato404),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column{
                Text(text=persona.nombre, style = MaterialTheme.typography.titleLarge)
                Text(text="Tiene: ${persona.edad}")
            }
            Icon(
                imageVector = if (persona.apto) Icons.Default.Check else Icons.Default.Close,
                contentDescription = "Palomita de verificación",
                tint = if (persona.apto) Color.Green else Color.Red,
                modifier = Modifier.height(80.dp).width(80.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonaCardPreview(){
    ProyectoTheme() {
        PersonaCard(
            Persona(1,"Brandon", apto = true),
            {}
        )
    }
}