package com.talhahasanzia.deezal.commons.contracts

/**
 * Presenter that will hold common signatures for all Presenters
 */
interface BasePresenter<T : BaseView> {
    // instead of letting each presenter do this in constructor, which is not guaranteed or consistent
    // each presenter will initialize view in same way, presenters can still have different constructor.
    fun initView(view : T)
}