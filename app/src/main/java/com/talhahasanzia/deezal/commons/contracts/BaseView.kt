package com.talhahasanzia.deezal.commons.contracts

import android.support.annotation.LayoutRes

/**
 * View (VIPER) that will hold common signatures for all Views
 * This will allow certain methods to be called from Presenter without requiring instance of activity
 * This holds contract that every View should implement
 */
interface BaseView {
    /**
     * Simple contract that enforces views to inject all the dependencies
     */
    fun inject()

    /**
     * Get xml reference so oncreate boiler plate is not written everytime
     */
    @LayoutRes
    fun getLayout() : Int

    /**
     * Simple error pop-up
     */
    fun showError(message : String)
}