package com.vandenbreemen.trainingcardsapp

import android.app.Application
import com.vandenbreemen.trainingcardsapp.di.AppComponent
import com.vandenbreemen.trainingcardsapp.di.DaggerAppComponent

/**
 *
 * @author kevin
 */
class CardsApp: Application() {

    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.create()
    }

}