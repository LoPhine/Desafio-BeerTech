package com.example.desafiobeertech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.desafiobeertech.repository.BeersListRepository
import com.example.desafiobeertech.viewmodel.BeersListViewModel
import com.example.desafiobeertech.viewmodel.BeersListViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = BeersListViewModelFactory(BeersListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(BeersListViewModel::class.java)
        val list = viewModel.cocktailList
        list.observe(this, Observer { beersList ->
            if(beersList.isNotEmpty()) {
                findViewById<TextView>(R.id.textView).text = beersList[0].product
            } else {
                findViewById<TextView>(R.id.textView).text = "Deu ruiim!"
            }

        })
    }
}