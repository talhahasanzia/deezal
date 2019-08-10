package com.talhahasanzia.deezal.commons.network
/**
 * This callback hides Retrofit class type Callback from Application layer.
 * This makes Network layer abstract to Application layer.
 * Any changes in Retrofit or Network layer should not effect app layer directly.
 */
interface ResponseCallback<in T : BaseResponseDto> {
    fun onSuccess(response: T)
    fun onFailure(message: String?, code: Int)
}
