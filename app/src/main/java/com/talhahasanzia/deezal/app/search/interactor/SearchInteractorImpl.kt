package com.talhahasanzia.deezal.app.search.interactor

import com.talhahasanzia.deezal.app.search.api.SearchArtistRequest
import com.talhahasanzia.deezal.app.search.api.SearchArtistResponse
import com.talhahasanzia.deezal.app.search.contracts.SearchInteractor
import com.talhahasanzia.deezal.app.search.contracts.SearchInteractorOut
import com.talhahasanzia.deezal.commons.network.Request
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import javax.inject.Inject

class SearchInteractorImpl @Inject constructor(private val searchArtistRequest: Request<SearchArtistResponse, String>) :
    SearchInteractor, ResponseCallback<SearchArtistResponse> {

    private lateinit var out: SearchInteractorOut

    override fun initOut(out: SearchInteractorOut) {
        this.out = out
    }

    override fun getArtists(query: String) {
        val data: HashMap<String, String> = HashMap()
        data[SearchArtistRequest.QUERY] = query
        searchArtistRequest.execute(data, this)
    }

    override fun onSuccess(response: SearchArtistResponse) {
        out.onArtistsFound(response.data)
        searchArtistRequest.dispose()
    }

    override fun onFailure(message: String?, code: Int) {
        message?.let {
            out.onArtistFailure(it)
        }
        searchArtistRequest.dispose()
    }
}