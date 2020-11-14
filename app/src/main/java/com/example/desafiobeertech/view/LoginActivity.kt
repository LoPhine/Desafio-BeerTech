package com.example.desafiobeertech.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.desafiobeertech.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener{
            GoToListBeer()
        }
    }
    private fun GoToListBeer(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}