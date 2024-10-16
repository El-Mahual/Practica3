package com.example.p3.ui.theme.views

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.Switch

import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Switch

import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.example.p3.model.Usuario
import com.example.p3.viewmodel.UsuariosViewModel


@Composable
fun FormularioView(navController: NavController, usuariosViewModel: UsuariosViewModel) {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var promedio by remember { mutableStateOf("") }
    var sigueEstudiando by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = edad, onValueChange = { edad = it }, label = { Text("Edad") })
        TextField(value = promedio, onValueChange = { promedio = it }, label = { Text(text = "Promedio") })
        Row {
            Text("¿Sigue estudiando?")
            Switch(checked = sigueEstudiando, onCheckedChange = { sigueEstudiando = it })
        }
        Button(onClick = {
            // Crear un nuevo usuario y guardar en la base de datos
            val nuevoUsuario = Usuario(nombre = nombre, edad = edad.toInt(), promedio = promedio.toFloat()
                .toDouble(), sigueEstudiando = sigueEstudiando)
            usuariosViewModel.addUsuario(nuevoUsuario)
            navController.popBackStack() // Regresar a la pantalla anterior
        }) {
            Text("Guardar")
        }
    }
}