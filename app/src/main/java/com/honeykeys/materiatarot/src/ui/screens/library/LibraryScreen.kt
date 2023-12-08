package com.honeykeys.materiatarot.src.ui.screens.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.honeykeys.materiatarot.src.ui.component.MateriaTopAppBar
import com.honeykeys.materiatarot.src.ui.screens.reading.ReadingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(viewModel: LibraryViewModel, readingViewModel: ReadingViewModel, navController: NavController) {

    val readingIds by viewModel.savedReadingLabels.collectAsState(initial = emptyList())
    val showDialog by viewModel.showDialog.observeAsState(false)

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.onDialogDismiss() },
            title = { Text("Delete Reading?") },
            confirmButton = {
                Button(
                    onClick = { viewModel.triggerSubmit() }
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
        topBar = { MateriaTopAppBar(navController) }
    ) { innerPadding ->
        Surface(
            modifier = Modifier,
            tonalElevation = 3.dp,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(readingIds) {readingId ->
                    LibraryItem(readingId, viewModel, readingViewModel, navController)
                        Divider()
                    }
                }
            }
        }
    }
}

@Composable
fun LibraryItem(
    readingNumber: Int,
    libraryViewModel: LibraryViewModel,
    readingViewModel: ReadingViewModel,
    navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .padding(14.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxHeight(),
                text = "Reading Number: $readingNumber",
                style = MaterialTheme.typography.headlineSmall
            )
        }
        Row (
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            horizontalArrangement = Arrangement.End){
            IconButton(onClick = {
                readingNumber.let { readingId ->
                    readingViewModel.triggerSavedReading(readingId)
                    navController.navigate("reading")
                    libraryViewModel.clearSelectedReadingId()
                }
            }) {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "Start Saved Reading"
                )
            }
            IconButton(onClick = {
                libraryViewModel.triggerDialog(readingNumber)
            }) {
                Icon(
                    Icons.Filled.Warning,
                    contentDescription = "Delete Saved Reading"
                )
            }
        }
    }
}