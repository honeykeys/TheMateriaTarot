package com.honeykeys.materiatarot.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.honeykeys.materiatarot.MateriaTarotApp
import com.honeykeys.materiatarot.presentation.theme.MateriaTarotTheme

class MainActivity : ComponentActivity() {
    private lateinit var readingViewModel: ReadingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = (application as MateriaTarotApp).appContainer
        val readingViewModel = appContainer.readingViewModelFactory.create()

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

@Composable
fun Greeting() {
    Text("Hello")
}

@Preview
@Composable
fun TarotPreview() {
    MateriaTarotTheme {
    }
}