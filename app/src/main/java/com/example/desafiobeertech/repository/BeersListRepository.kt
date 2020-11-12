package com.example.desafiobeertech.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.desafiobeertech.network.Beers
import com.example.desafiobeertech.network.BeersApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BeersListRepository {
    private val beersListResponse = MutableLiveData<List<Beers>>()

    val  beersList: LiveData<List<Beers>>
        get() = beersListResponse

    init {
        getBeersList()
    }

    private fun getBeersList() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val listResult = BeersApi.retrofitService.getBeers().BeersList
                beersListResponse.postValue(listResult)

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    beersListResponse.postValue(listOf())
                }
            }
        }
    }
}