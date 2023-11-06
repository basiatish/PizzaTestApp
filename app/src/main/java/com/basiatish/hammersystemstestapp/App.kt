package com.basiatish.hammersystemstestapp

import android.app.Application
import com.basiatish.hammersystemstestapp.di.AppComponent
import com.basiatish.hammersystemstestapp.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create()
    }

}