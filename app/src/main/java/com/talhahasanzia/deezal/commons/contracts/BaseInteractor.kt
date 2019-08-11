package com.talhahasanzia.deezal.commons.contracts

/**
 * Interactor that will hold common signatures for all interactor.
 * It has an output port (as per clean architecture design)
 * which will post outcomes of operations when this interactor is given any task
 */
interface BaseInteractor<T : BaseInteractorOut>{
    // instead of letting each interactor do this in constructor, which is not guaranteed or consistent
    // each interactor will initialize its "out" in same way, interactors can still have different constructor.
    fun initOut(out : T)
}