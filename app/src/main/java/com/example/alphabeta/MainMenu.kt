package com.example.alphabeta

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    fun takeOnLetter(view: View) {
        val randomIntent = Intent(this, MainActivity::class.java)
        startActivity(randomIntent)
    }
}


