package com.honeykeys.materiatarot.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.honeykeys.materiatarot.MateriaTarotApp
import com.honeykeys.materiatarot.di.AppContainer
import com.honeykeys.materiatarot.presentation.component.MateriaBottomAppBar
import com.honeykeys.materiatarot.presentation.component.MateriaTopAppBar
import com.honeykeys.materiatarot.presentation.theme.MateriaTarotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = (application as MateriaTarotApp).appContainer

        setContent {
            MateriaTarotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}
/* USING THE BELOW TABLE TO BUILD PREVIEWS */

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewDark"
)
@Composable
fun ReadingScreenPreview() {
    val container = AppContainer()
    val viewModel = container.readingViewModel
    Scaffold(
        topBar = { MateriaTopAppBar() },
        bottomBar = { MateriaBottomAppBar() }
    ) { innerPadding ->
        Surface(
            modifier = Modifier,
            tonalElevation = 3.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}