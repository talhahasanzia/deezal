package com.talhahasanzia.deezal.commons.ui

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.commons.contracts.BaseView

/**
 * Since BaseActivity can implement BaseView, it can provide some boiler plate logic like error pop-up.
 * This implementation is available to any child, but more importantly this is available to presenter
 * without knowing where the implementation is coming from.
 *
 * getLayout() and inject() are called here in onCreate() so child class can provide layout and inject implementation
 * without implementing onCreate() again.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        inject()
        onCreate()
    }

    override fun showError(message: String) {
        val dialog = AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialogInterface, _ -> dialogInterface.dismiss() }
            .create()

        dialog.show()
    }

    // if child activity wants to work with onCreate it can use simpler signature
    protected open fun onCreate(){
    }
}