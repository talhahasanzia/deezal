package com.talhahasanzia.deezal.commons.contracts

/**
 * Interactor that will hold common signatures for all interactor.
 * It has an output port (as per clean architecture design)
 * which will post outcomes of operations when this interactor is given any task
 */
interface BaseInteractor{
    fun initOut(out : Any)
}