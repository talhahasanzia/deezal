package com.talhahasanzia.deezal.app.search.api

import com.talhahasanzia.deezal.commons.network.BaseRequest
import com.talhahasanzia.deezal.commons.network.ResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchArtistRequest : BaseRequest<SearchArtistResponse, String>() {

    // Keys for data specific to this request
    companion object Keys {
        const val QUERY = "query"
    }

    override fun execute(data: HashMap<String, String>, responseCallback: ResponseCallback<SearchArtistResponse>) {
        data[QUERY]?.let {
            disposable.add(
                retrofit.create(SearchAPI::class.java)
                    .getArtistBySearch(it)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(responseCallback::onSuccess) { e -> responseCallback.onFailure(e.message, -1) }
            )
        }

    }
}