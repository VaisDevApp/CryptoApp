package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.presentation.CoinDetailFragment
import com.example.cryptoapp.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [DataModul::class, ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(activity:CoinPriceListActivity)
    fun inject(fragment: CoinDetailFragment)
    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}