package com.example.cryptoapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.cryptoapp.adapters.CoinInfoAdapter
import com.example.cryptoapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.activity_coin_prce_list.*

class CoinPriceListActivity : AppCompatActivity() {

    private val viewModel: CoinViewModel by viewModels <CoinViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_prce_list)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinPriceInfo.fromSymbol
                )
                startActivity(intent)
            }
        }
        rvCoinPriceList.adapter = adapter
       //viewModel = ViewModelProviders.of(this)[CoinViewModel::class.java]
       viewModel.priceList.observe(this, Observer {
        adapter.coinInfoList = it
       })
    }
}
