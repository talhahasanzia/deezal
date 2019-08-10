package com.talhahasanzia.deezal.commons.contracts

import android.content.Context
import android.os.Bundle

/**
 * Base router contract to hide routing details from caller
 * Call startActivity when implementing this method to navigate to other Activity
 */
interface BaseRouter {
    fun route(context: Context, bundle: Bundle)
}