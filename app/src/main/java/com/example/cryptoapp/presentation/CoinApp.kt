package com.example.cryptoapp.presentation

import android.app.Application
import com.example.cryptoapp.data.workers.CoinWorkerFactory
import com.example.cryptoapp.di.DaggerApplicationComponent
import javax.inject.Inject

class CoinApp : Application(), androidx.work.Configuration.Provider {
    @Inject
    lateinit var workerFactory: CoinWorkerFactory

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getWorkManagerConfiguration(): androidx.work.Configuration {
        return androidx.work.Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}