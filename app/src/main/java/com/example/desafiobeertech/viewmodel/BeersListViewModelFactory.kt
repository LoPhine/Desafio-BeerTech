package com.example.desafiobeertech.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiobeertech.repository.BeersListRepository

class BeersListViewModelFactory(private val repository: BeersListRepository):  ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BeersListViewModel::class.java)) {
                return BeersListViewModel(repository) as T
            }
            throw IllegalArgumentException("Deu ruim!")
        }
}
