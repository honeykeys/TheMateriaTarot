package com.honeykeys.materiatarot.src.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.honeykeys.materiatarot.src.di.AppContainer
import com.honeykeys.materiatarot.src.ui.screens.library.LibraryScreen
import com.honeykeys.materiatarot.src.ui.screens.reading.ReadingScreen
import com.honeykeys.materiatarot.src.ui.theme.MateriaTarotTheme

@Composable
fun TarotApp() {

    val navController = rememberNavController()
    val appContainer = AppContainer()

    NavHost(navController, startDestination = "reading") {
        composable("reading") { ReadingScreen(appContainer.readingViewModel, navController) }
        composable("library") {
            LibraryScreen(appContainer.libraryViewModel, appContainer.readingViewModel, navController)
        }
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MateriaTarotTheme {
                // A surface container using the 'background' color from the theme
               TarotApp()
            }
        }
    }
}
