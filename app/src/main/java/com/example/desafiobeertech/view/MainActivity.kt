package com.example.desafiobeertech.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafiobeertech.R
import com.example.desafiobeertech.network.BeersApiService
import com.example.desafiobeertech.network.BeersResponse
import com.example.desafiobeertech.repository.BeersListRepository
import com.example.desafiobeertech.viewmodel.BeersListViewModel
import com.example.desafiobeertech.viewmodel.BeersListViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = BeersListRepository()

        val viewModelFactory = BeersListViewModelFactory(BeersListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(BeersListViewModel::class.java)
        val list = viewModel.cocktailList

        val recyclerView = findViewById<RecyclerView>(R.id.itemsProductRecyclerView)
        val adapter = ProductItemAdapter()
        recyclerView.adapter = adapter

        list.observe(this, Observer {
            adapter.data = it
            recyclerView.visibility = View.VISIBLE


        })
    }
}


