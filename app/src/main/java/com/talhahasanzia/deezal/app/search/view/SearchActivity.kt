package com.talhahasanzia.deezal.app.search.view

import android.support.annotation.LayoutRes
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import com.jakewharton.rxbinding.support.v7.widget.RxSearchView
import com.talhahasanzia.deezal.R
import com.talhahasanzia.deezal.app.search.adapters.ArtistsAdapter
import com.talhahasanzia.deezal.app.search.api.Data
import com.talhahasanzia.deezal.app.search.contracts.SearchPresenter
import com.talhahasanzia.deezal.app.search.contracts.SearchView
import com.talhahasanzia.deezal.app.search.dependencies.DaggerSearchComponent
import com.talhahasanzia.deezal.commons.extensions.hide
import com.talhahasanzia.deezal.commons.extensions.show
import com.talhahasanzia.deezal.commons.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_search.*
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchActivity : BaseActivity(), SearchView {

    @Inject
    lateinit var presenter: SearchPresenter

    private lateinit var adapter: ArtistsAdapter

    @LayoutRes
    override fun getLayout(): Int {
        return R.layout.activity_search
    }

    override fun onCreate() {
        presenter.initView(this)
        initSearchView()
        initArtistsRecyclerView()
    }

    private fun initSearchView() {
        // since we don't want to request API on every change, we wait for the user to stop typing for 1 second then call API
        RxSearchView.queryTextChanges(artistSearchView)
            .debounce(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe(::onTextChangedAfterDelay)
    }

    private fun initArtistsRecyclerView() {
        // initialize with empty data first time
        adapter = ArtistsAdapter(ArrayList())

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        artistResultsRecyclerView.layoutManager = layoutManager
        artistResultsRecyclerView.adapter = adapter
    }

    private fun onTextChangedAfterDelay(chars: CharSequence) {
        loader.show()
        adapter.clearData()
        presenter.onTextChanged(chars.toString())
    }

    override fun inject() {
        DaggerSearchComponent
            .create()
            .inject(this)
    }

    override fun clearErrors() {
        loader.hide()
        adapter.clearData()
        searchErrorText.hide()
    }

    override fun showNoArtistsFound() {
        loader.hide()
        adapter.clearData()
        searchErrorText.show()
    }

    override fun setArtistsData(data: List<Data>) {
        clearErrors()
        adapter.updateData(data)
    }
}
