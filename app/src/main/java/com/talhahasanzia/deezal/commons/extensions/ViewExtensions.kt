package com.talhahasanzia.deezal.commons.extensions

import android.view.View

/**
 * Some helper methods for views to avoid boiler plate
 */

fun View.show(){
    this.visibility= View.VISIBLE
}

fun View.hide(){
    this.visibility= View.INVISIBLE
}

fun View.enable(){
    this.isEnabled= true
}

fun View.disable(){
    this.isEnabled= false
}