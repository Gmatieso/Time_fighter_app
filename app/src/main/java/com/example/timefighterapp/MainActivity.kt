package com.example.timefighterapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    // variable initialization
    internal var score = 0
    // reference to our button view properties or declaring the variable
    internal lateinit var myButton: Button
    //reference to our TextView properties
    internal lateinit var gameScoreTextView: TextView
    // reference to our TextView timeleft
    internal lateinit var timeleft: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // populating our properties or assignment of data
        myButton = findViewById(R.id.tap_me)
        gameScoreTextView = findViewById(R.id.gameScoreTextView)
        timeleft = findViewById(R.id.timeLeftTextview)
        //handle a tap by setting the onClick listener
        myButton.setOnClickListener { view ->
            incrementScore()

        }

    }

    private fun incrementScore() {
        // implementing body of the method
        score += 1
        // updated text score
        val newScore = getString(R.string.yourScore, score)
        gameScoreTextView.text = newScore
    }
}