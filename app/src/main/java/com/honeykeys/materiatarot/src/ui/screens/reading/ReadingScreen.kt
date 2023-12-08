package com.honeykeys.materiatarot.src.ui.screens.reading

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.honeykeys.materiatarot.src.ui.component.MateriaTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingScreen(viewModel: ReadingViewModel, navController: NavController) {

    val layoutOptions = listOf("single", "time", "situation", "cross", "year")
    val showDialog by viewModel.showDialog.observeAsState(false)
    var layout by remember { mutableStateOf(layoutOptions[0])}
    var question by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false)}
    val activeReading by viewModel.activeReading.observeAsState(initial = false)

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.onDialogDismiss() },
            title = { Text("New Reading") },
            text = {
                Column {
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        layoutOptions.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(text = option, style = MaterialTheme.typography.labelLarge) },
                                onClick = {
                                layout = option
                                expanded = false
                            })
                        }
                    }
                    Text(
                        text = layout,
                        modifier = Modifier.clickable { expanded = true }
                    )
                    TextField(
                        value = question,
                        onValueChange = { question = it },
                        label = { Text("Question") }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = { viewModel.onDialogSubmit(layout, question) }
                ) {
                    Text("Submit")
                }
            },
            dismissButton = {
                Button(onClick = { viewModel.onDialogDismiss() }) {
                    Text("Cancel")
                }
            }
        )
    }

    Scaffold(
        topBar = { MateriaTopAppBar(navController) },
        bottomBar = {
            BottomAppBar(
            actions = {
                IconButton(
                    onClick = {viewModel.triggerReadingSave()}
                ){
                    Icon(
                        Icons.Filled.FavoriteBorder,
                        contentDescription = "Save Reading",
                    )
                }
                IconButton(
                    onClick = {viewModel.toggleDetails()}

                ) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Show Details"
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { viewModel.triggerNewReadingDialog()},
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Icon(Icons.Default.Add, "Localized description")
                }
            }
        )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            ) {
                if (activeReading) {
                    TarotCardCarousel(viewModel = viewModel)
                } else {
                    Text("Please Hit Start Reading")
                }

                }
        }
    )
}
