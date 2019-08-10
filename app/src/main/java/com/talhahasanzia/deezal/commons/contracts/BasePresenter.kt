package com.talhahasanzia.deezal.commons.contracts

/**
 * Presenter that will hold common signatures for all Presenters
 */
interface BasePresenter<T : BaseView> {
    fun initView(view : T)
}