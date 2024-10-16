package com.example.p3.ui.theme.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.p3.viewmodel.UsuariosViewModel
@Composable
fun HomeView(navController: NavController, usuariosViewModel: UsuariosViewModel) {
    // Recolecta la lista de usuarios desde el ViewModel
    val usuarios by usuariosViewModel.usuariosList.collectAsState()

    // Variables para controlar qué datos mostrar
    var showId by remember { mutableStateOf(false) }
    var showEdad by remember { mutableStateOf(false) }
    var showPromedio by remember { mutableStateOf(false) }
    var showEstudiando by remember { mutableStateOf(false) }

    // Contenedor principal
    Column {
        // Filtros para mostrar los datos
        Row {
            Checkbox(checked = showId, onCheckedChange = { showId = it })
            Text("Mostrar ID")
        }
        Row {
            Checkbox(checked = showEdad, onCheckedChange = { showEdad = it })
            Text("Mostrar Edad")
        }
        Row {
            Checkbox(checked = showPromedio, onCheckedChange = { showPromedio = it })
            Text("Mostrar Promedio")
        }
        Row {
            Checkbox(checked = showEstudiando, onCheckedChange = { showEstudiando = it })
            Text("Mostrar Estudiando")
        }

        // Lista de usuarios
        LazyColumn {
            items(usuarios) { usuario ->
                Column {
                    if (showId) Text("ID: ${usuario.id}")
                    Text("Nombre: ${usuario.nombre}") // Mostrar el nombre correctamente
                    if (showEdad) Text("Edad: ${usuario.edad}")
                    if (showPromedio) Text("Promedio: ${usuario.promedio}")
                    if (showEstudiando) Text("¿Sigue estudiando? ${if (usuario.sigueEstudiando) "Sí" else "No"}")
                }
            }
        }

        // Botón para agregar un nuevo usuario
        Button(onClick = { navController.navigate("formulario") }) {
            Text("Agregar Usuario")
        }
    }
}
