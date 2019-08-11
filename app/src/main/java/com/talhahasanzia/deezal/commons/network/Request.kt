package com.talhahasanzia.deezal.commons.network

/**
 * This is the interface that will define contract for every Request Logic in the app.
 * This is not Retrofit Call T, this is an abstraction over it so app does not have to deal with retrofit details directly,
 * network layer has this responsibility.
 *
 * To define request specifications like end points or payloads extend BaseRequest and implement this interface to specify Response type T.
 * This layer will act as mediator between pure network logic and application layer
 * Any changes in Retrofit or Network layer should not effect app layer directly
 * T: type of response object
 * R: type of request object
 */
interface Request<T : BaseResponseDto, R : Any> {
    /**
     * Execute request with any data passed that is required in request. And a callback in which result of the request will be delivered.
     * We can pass data in key value pair, but we need to specify this data type R when implementing execute().
     * Creation of request body or other json or request related object must be in specific request implementation
     */
    fun execute(data: HashMap<String, R>, responseCallback: ResponseCallback<T>)

    /**
     * Call dispose after receiving result either success or failure since this object created an observable
     */
    fun dispose()
}
