package com.talhahasanzia.deezal.commons.application

import android.app.Application
import com.talhahasanzia.deezal.BuildConfig
import com.talhahasanzia.deezal.commons.logging.DeezalLogger

class DeezalApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        // only log in debug builds
        DeezalLogger.loggingEnabled = BuildConfig.DEBUG
    }
}