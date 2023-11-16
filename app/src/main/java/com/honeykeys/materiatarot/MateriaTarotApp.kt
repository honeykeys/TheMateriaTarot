package com.honeykeys.materiatarot

import android.app.Application
import android.content.Context


class MateriaTarotApp: Application() {
    companion object {
        private lateinit var instance: MateriaTarotApp
        fun getAppContext(): Context {
            return instance.applicationContext
        }
    }
    val appContainer = AppContainer()

}