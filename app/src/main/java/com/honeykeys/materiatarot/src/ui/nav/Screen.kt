package com.honeykeys.materiatarot.src.ui.nav

sealed class Screen(val route: String) {
    object Reading: Screen("reading")
    object Library: Screen("library")
}
