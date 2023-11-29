package com.honeykeys.materiatarot.presentation.screens.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.honeykeys.materiatarot.presentation.component.MateriaBottomAppBar
import com.honeykeys.materiatarot.presentation.component.MateriaTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(viewModel: LibraryViewModel) {
    val readingMap = viewModel.getLibrary()
    Scaffold(
        topBar = { MateriaTopAppBar() },
        bottomBar = { MateriaBottomAppBar() }
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
                LibraryColumn(readingMap = readingMap)
            }
        }
    }
}
@Composable
fun LibraryColumn(readingMap: Map<Int, String>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(readingMap.toList()) { (readingNumber, readingDate) ->
            Row {
                LibraryItem(readingNumber, readingDate)
            }
            if (readingNumber != readingMap.keys.last()) {
                Divider()
            }
        }
    }
}
@Composable
fun LibraryItem(readingNumber: Int, readingDate: String) {
    Column {
        Text(
            textAlign = TextAlign.Center,
            text = "Reading Number: $readingNumber",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = readingDate,
            style = MaterialTheme.typography.bodySmall
        )
    }
}