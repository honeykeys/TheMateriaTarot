package com.honeykeys.materiatarot.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.util.concurrent.Flow

@Composable
fun LibraryList(library: Flow<List<Int>>) {
    val libraryReadings by libraryFlow.collectAsState(initial = emptyList<Int>())
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(libraryReadings) { reading ->
            Text(
                text = "Reading $reading.toString()",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}