package com.honeykeys.materiatarot.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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