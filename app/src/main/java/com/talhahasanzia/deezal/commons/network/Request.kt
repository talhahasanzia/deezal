package com.talhahasanzia.deezal.commons.network

/**
 * This is the interface that will define contract for every Request Logic in the app.
 * This is not Retrofit Call T, this is an abstraction over it so app does not have to deal with retrofit details directly,
 * network layer has this responsibility.
 *
 * To define request specifications like end points or payloads extend BaseRequest and implement this interface to specify Response type T.
 * This layer will act as mediator between pure network logic and application layer
 * Any changes in Retrofit or Network layer should not effect app layer directly
 */
interface Request<T : BaseResponseDto> {
    fun execute(responseCallback: ResponseCallback<T>)
    fun dispose()
}
