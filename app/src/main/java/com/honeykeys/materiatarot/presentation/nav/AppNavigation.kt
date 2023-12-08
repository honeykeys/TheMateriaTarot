package com.honeykeys.materiatarot.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.honeykeys.materiatarot.di.AppContainer
import com.honeykeys.materiatarot.presentation.screens.library.LibraryScreen
import com.honeykeys.materiatarot.presentation.screens.reading.ReadingScreen
@Composable
fun AppNavigation(appContainer: AppContainer) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "reading" ) {
        composable("reading") {
            // Pass the ReadingViewModel from the app container
            ReadingScreen(appContainer.readingViewModel, navController)
        }
        composable("library") {
            // Pass the LibraryViewModel from the app container
            LibraryScreen(appContainer.libraryViewModel, appContainer.readingViewModel, navController)
        }
    }
}
