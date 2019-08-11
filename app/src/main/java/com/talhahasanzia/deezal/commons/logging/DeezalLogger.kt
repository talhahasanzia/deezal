package com.talhahasanzia.deezal.commons.logging

import android.util.Log

object DeezalLogger {

    var loggingEnabled = false

    fun log(message: String, tag : String = "DeezalLog") {
        if(loggingEnabled){
            Log.d(tag, message)
        }
    }

}