package com.honeykeys.materiatarot.presentation.nav

sealed class Screen(val route: String) {
    object Reading: Screen("reading")
    object Library: Screen("library")
    object Settings: Screen("settings")
}
