package com.jakubu9333.bestartists

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val newArtistsButton : Button = findViewById(R.id.button)
        val recyclerView: RecyclerView= findViewById(R.id.recyclerView)


    }
}