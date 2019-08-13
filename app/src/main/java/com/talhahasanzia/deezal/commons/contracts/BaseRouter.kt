package com.talhahasanzia.deezal.commons.contracts

import android.content.Context

/**
 * Base router contract to hide routing details from caller
 * Call startActivity when implementing this method to navigate to other Activity
 * <T> type allows implementing class to choose which type of data it requires to navigate to certain screen
 */
interface BaseRouter<T> {
    fun route(context: Context, data: T)
}