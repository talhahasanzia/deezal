package com.talhahasanzia.deezal.commons.network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Since most of the responses are parsed in the same way,
 * we write a default implementation of the "abstract" layer
 * which will run once retrofit gets response and hand over to our own network layer.
 */
class DefaultResponseCallback<T : BaseResponseDto>(private val responseCallback: ResponseCallback<T>) : Callback<T> {

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        // call onFailure on ResponseCallback
        responseCallback.onFailure(t?.message, -1)
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        // cast the response into specified Type of DTO <T>
        val parsedResponse: T = response?.body() as T
        // set
        parsedResponse.success = response.isSuccessful
        // check if server resolved query successfully
        if (parsedResponse.success) {
            responseCallback.onSuccess(parsedResponse)
        } else {
            // call was made to server, but there was issue resolving our query
            responseCallback.onFailure(getFailureMessage(response), response.code())
        }
    }

    /**
     * Parse error from the json body
     */
    private fun getFailureMessage(response: Response<T>): String? {
        return "Something went wrong"
    }

}