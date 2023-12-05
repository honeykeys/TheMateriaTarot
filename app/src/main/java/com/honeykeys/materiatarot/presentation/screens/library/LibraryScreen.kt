package com.honeykeys.materiatarot.presentation.screens.library

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.honeykeys.materiatarot.presentation.component.MateriaTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen(viewModel: LibraryViewModel, navController: NavController) {
    val readingMap = viewModel.getLibrary()
    val cardNames = viewModel.getCardNames()
    val navController = rememberNavController()

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
                    items(readingMap.toList()) { (readingNumber, readingDate) ->
                        Row {
                            LibraryItem(readingNumber, readingDate, cardNames)
                        }
                        if (readingNumber != readingMap.keys.last()) {
                            Divider()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LibraryItem(readingNumber: Int, readingDate: String, cardNames: List<Int>) {
    var isExpanded by remember {mutableStateOf(false)}
    Column  (modifier = Modifier.clickable {isExpanded = !isExpanded}){
        Text(
            textAlign = TextAlign.Center,
            text = "Reading Number: $readingNumber",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = readingDate,
            style = MaterialTheme.typography.bodySmall
        )
        AnimatedVisibility(visible = isExpanded) {
            Column {
                cardNames.forEach { cardNameId ->
                    Text(
                        text = stringResource(id = cardNameId),
                        style = MaterialTheme.typography.bodySmall
                    )

                }
            }
        }
    }
}