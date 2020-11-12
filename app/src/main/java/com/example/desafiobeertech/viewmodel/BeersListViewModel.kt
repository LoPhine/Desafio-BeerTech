package com.example.desafiobeertech.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.desafiobeertech.network.Beers
import com.example.desafiobeertech.repository.BeersListRepository

class BeersListViewModel(private val repository: BeersListRepository): ViewModel() {
    val  cocktailList: LiveData<List<Beers>>
        get() = repository.beersList
}