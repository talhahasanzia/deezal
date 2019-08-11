package com.talhahasanzia.deezal.app.search.api

import com.talhahasanzia.deezal.commons.network.BaseRequest
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchArtistRequest(private val searchQuery: String) : BaseRequest<SearchArtistResponse>() {

    override fun execute(responseCallback: ResponseCallback<SearchArtistResponse>) {
        disposable.add(retrofit.create(SearchAPI::class.java)
            .getArtistBySearch(searchQuery)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(responseCallback::onSuccess) { e -> responseCallback.onFailure(e.message, -1) }
        )
    }
}