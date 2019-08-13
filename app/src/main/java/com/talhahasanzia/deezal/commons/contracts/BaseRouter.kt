package com.talhahasanzia.deezal.commons.contracts

import android.content.Context

/**
 * Base router contract to hide routing details from caller
 * Call startActivity when implementing this method to navigate to other Activity
 */
interface BaseRouter<T> {
    fun route(context: Context, data: T)
}