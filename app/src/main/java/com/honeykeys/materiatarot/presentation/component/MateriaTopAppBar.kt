package com.honeykeys.materiatarot.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.honeykeys.materiatarot.presentation.nav.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MateriaTopAppBar(navController: NavHostController) {
    var selectedTabIndex by remember {(mutableIntStateOf(0))}

    TopAppBar (
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
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = {
                        selectedTabIndex = 0
                        navController.navigate(Screen.Reading.route)
                              },
                    text = { Text("Reading") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Reading"
                        )
                    }
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = {
                        selectedTabIndex = 1
                        navController.navigate(Screen.Library.route)
                              },
                    text = { Text("Library") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.List,
                            contentDescription = "Library"
                        )
                    }

                )
                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = {
                        selectedTabIndex = 2
                        navController.navigate((Screen.Settings.route))
                              },
                    text = { Text("Settings") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Setting"
                        )
                    }
                )
            }
        }
        )
}
