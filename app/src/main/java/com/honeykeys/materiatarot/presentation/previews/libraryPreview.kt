package com.honeykeys.materiatarot.presentation.previews

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.honeykeys.materiatarot.presentation.component.MateriaBottomAppBar
import com.honeykeys.materiatarot.presentation.component.MateriaTopAppBar
import com.honeykeys.materiatarot.presentation.screens.library.LibraryColumn
import com.honeykeys.materiatarot.presentation.theme.MateriaTarotTheme

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewDark"
)
@Composable
fun LibraryScreenPreview() {
    val testMap = mapOf(
        1 to "November 16, 2023",
        2 to "2023-11-15",
        3 to "2023-11-14",
        4 to "2023-11-12",
        5 to "2023-11-11",
        6 to "2023-11-10",
        7 to "2023-11-09",
        8 to "2023-11-08",
        9 to "2023-11-07",
        10 to "2023-11-06",
        11 to "2023-11-05",
        12 to "2023-11-04",
        13 to "2023-11-03",
        14 to "2023-11-02",
        15 to "2023-11-01",
        16 to "2023-10-31",
        17 to "2023-10-30",
        18 to "2023-10-29",
        19 to "2023-10-28",
        20 to "2023-10-27"
    )
    MateriaTarotTheme {
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
                    LibraryColumn(readingMap = testMap)
                }
            }
        }
    }
}