package com.honeykeys.materiatarot.presentation.screens.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.honeykeys.materiatarot.presentation.component.MateriaTopAppBar
import com.honeykeys.materiatarot.presentation.screens.reading.ReadingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(viewModel: LibraryViewModel, readingViewModel: ReadingViewModel, navController: NavController) {

    val readingIds by viewModel.savedReadingLabels.collectAsState(initial = emptyList())

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
    Row() {
        Text(
            textAlign = TextAlign.Center,
            text = "Reading Number: $readingNumber",
            style = MaterialTheme.typography.bodyLarge
        )
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
    }
}