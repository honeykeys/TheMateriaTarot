package com.honeykeys.materiatarot.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.room.Room
import com.honeykeys.materiatarot.data.ReadingDatabase
import com.honeykeys.materiatarot.presentation.theme.MateriaTarotTheme
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {

    private val readingViewModel: ReadingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val db = Room.databaseBuilder(
            applicationContext,
            ReadingDatabase::class.java, "reading"
        ).build()
        super.onCreate(savedInstanceState)
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
}

@Preview
@Composable
fun TarotPreview() {

    val viewModel = ReadingViewModel()

    MateriaTarotTheme {
        HomeScreen(viewModel = viewModel)
    }
}