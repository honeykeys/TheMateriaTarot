package com.honeykeys.materiatarot.base

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MateriaTopAppBar() {
    TopAppBar (
        title = { Text(text = "The Materia Tarot")}
    ) }

@Composable
fun MateriaBottomAppBar() {
    BottomAppBar(contentColor = Color.Green) {
        /* BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            BottomNavigationItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                label = { Text("Home") },
                selected = currentRoute == "home", // Replace with your route name
                onClick = {
                    navController.navigate("home") // Replace with your destination route
                }
            )
        } */
    }
}