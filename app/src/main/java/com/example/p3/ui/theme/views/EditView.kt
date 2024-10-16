package com.example.p3.ui.theme.views

NavHost(navController = navController, startDestination = "home") {
    composable("home") { HomeView(navController, usuariosViewModel) }
    composable("formulario") { FormularioView(navController, usuariosViewModel) }
}