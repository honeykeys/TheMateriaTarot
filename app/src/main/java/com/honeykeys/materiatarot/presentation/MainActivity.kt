package com.honeykeys.materiatarot.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.honeykeys.materiatarot.MateriaTarotApp
import com.honeykeys.materiatarot.di.AppContainer
import com.honeykeys.materiatarot.presentation.nav.Screen
import com.honeykeys.materiatarot.presentation.screens.library.LibraryScreen
import com.honeykeys.materiatarot.presentation.screens.reading.ReadingScreen
import com.honeykeys.materiatarot.presentation.theme.MateriaTarotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = MateriaTarotApp.instance.appContainer
        setContent {
            MateriaTarotTheme {
                // A surface container using the 'background' color from the theme
               AppNavigation(appContainer = appContainer)
            }
        }
    }
}
@Composable
fun AppNavigation(appContainer: AppContainer) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Library.route) {
        composable(Screen.Library.route) {
            // Pass the LibraryViewModel from the app container
            LibraryScreen(appContainer.libraryViewModel, navController)
        }
        composable(Screen.Reading.route) {
            // Pass the ReadingViewModel from the app container
            ReadingScreen(appContainer.readingViewModel, navController)
        }
    }
}
