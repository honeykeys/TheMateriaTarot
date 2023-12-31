package com.honeykeys.materiatarot.src

import android.app.Application
import android.content.Context
import com.honeykeys.materiatarot.src.di.AppContainer


class MateriaTarotApp: Application() {

    lateinit var appContainer: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContainer = AppContainer()
    }

    companion object {
        lateinit var instance: MateriaTarotApp
            private set
        fun getAppContext(): Context {
            return instance.applicationContext
        }
    }

}