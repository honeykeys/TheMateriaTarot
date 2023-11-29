package com.honeykeys.materiatarot

import android.app.Application
import android.content.Context
import com.honeykeys.materiatarot.di.AppContainer


class MateriaTarotApp: Application() {
    companion object {
        private lateinit var instance: MateriaTarotApp
        fun getAppContext(): Context {
            return instance.applicationContext
        }
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    val appContainer = AppContainer()
}