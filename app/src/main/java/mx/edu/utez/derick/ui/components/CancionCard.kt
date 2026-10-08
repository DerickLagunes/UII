package mx.edu.utez.derick.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.derick.R
import mx.edu.utez.derick.models.Cancion
import mx.edu.utez.derick.ui.theme.ProyectoTheme

@Composable
fun CancionCard(
    cancion: Cancion,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(cancion.album ?: R.drawable._404),
                contentDescription = "Album de la canción",
                modifier = Modifier.width(200.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(){
                Text(text=cancion.nombre, style = MaterialTheme.typography.titleLarge)
                Text(text=cancion.genero, style = MaterialTheme.typography.labelLarge)
                Text(text=cancion.duracion)
            }
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                imageVector = if (cancion.favorito) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorito",
                tint = if (cancion.favorito) Color.Red else Color.Gray,
                modifier = Modifier.width(40.dp).height(40.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CancionCardPreview(){
    ProyectoTheme{
        val can = Cancion(1, "Selfless", "Rock/Pop", "3:12", true, R.drawable.logogato)
        CancionCard(can, {})
    }
}