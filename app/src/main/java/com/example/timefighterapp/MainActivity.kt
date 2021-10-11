package com.example.timefighterapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    // reference to our button view properties
    internal lateinit var myButton: Button
    //reference to our TextView properties
    internal lateinit var gameScoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // populating our properties 
        myButton = findViewById(R.id.tap_me)
        gameScoreTextView = findViewById(R.id.gameScoreTextView)
    }
}