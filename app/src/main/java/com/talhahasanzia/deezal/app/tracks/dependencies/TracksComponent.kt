package com.talhahasanzia.deezal.app.tracks.dependencies

import com.talhahasanzia.deezal.app.tracks.view.TracksActivity
import dagger.Component

@TracksScope
@Component(modules = [TracksModule::class])
interface TracksComponent {
    fun inject(tracksActivity: TracksActivity)
}