package com.honeykeys.materiatarot.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MateriaTopAppBar(navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    TopAppBar(
        title = {
            Text(
                text = "The Materia Tarot",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        },
        actions = {
            TabRow(selectedTabIndex = selectedTabIndex) {
                TopAppBarTab(
                    index = 0,
                    selectedTabIndex = selectedTabIndex,
                    label = "Reading",
                    icon = Icons.Filled.Home,
                    navController = navController,
                    route = "reading"
                )
                TopAppBarTab(
                    index = 1,
                    selectedTabIndex = selectedTabIndex,
                    label = "Library",
                    icon = Icons.Filled.List,
                    navController = navController,
                    route = "library"
                )
                // Add more tabs as needed
            }
        }
    )
}

@Composable
fun TopAppBarTab(
    index: Int,
    selectedTabIndex: Int,
    label: String,
    icon: ImageVector,
    navController: NavController,
    route: String
) {
    Tab(
        selected = selectedTabIndex == index,
        onClick = {
            navController.navigate(route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        text = { Text(label) },
        icon = { Icon(icon, contentDescription = label) }
    )
}