package com.example.timefighterapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    // variable initialization
    internal var score = 0
    // reference to our button view widget  or declaring the variable
    internal lateinit var myButton: Button
    //reference to our TextView  widget  gameScoreTextView properties
    internal lateinit var gameScoreTextView: TextView
    // reference to our TextView timeleft widget 
    internal lateinit var timeLeftTextView: TextView
    
    
    internal var gamestarted = false

    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDown: Long = 60000
    internal val countDownInterval: Long = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // populating our properties or assignment of data
        myButton = findViewById(R.id.tap_me)
        gameScoreTextView = findViewById(R.id.gameScoreTextView)
        timeLeftTextView = findViewById(R.id.timeLeftTextview)

        //handle a tap by setting the onClick listener
        myButton.setOnClickListener { view ->
            incrementScore()

        }
        // Calling the reset game method
       resetGame()

    }
    //create method resetGame()
    private fun resetGame() {
        score = 0
        gameScoreTextView.text = getString(R.string.yourScore, score)
        val initializeTimeLeft = initialCountDown / 1000
        timeLeftTextView.text = getString(R.string.timeleft,initializeTimeLeft)

        countDownTimer  = object : CountDownTimer( initialCountDown, countDownInterval) {
            override  fun onTick(millisuntilFinished:Long){
                val timeLeft = millisuntilFinished / 1000
                timeLeftTextView.text  = getString(R.string.timeleft, timeLeft)

            }

            override fun onFinish() {
                endGame()
            }
        }
        gamestarted  = false
    }

    private fun incrementScore() {
        if (!gamestarted){
            startGame()
        }
        // implementing body of the method
        score += 1
        // updated text score
        val newScore = getString(R.string.yourScore, score)
        gameScoreTextView.text = newScore
    }
    private fun startGame(){
        countDownTimer.start()
        gamestarted = true
    }
    private fun endGame(){
        Toast.makeText(this,getString(R.string.gameOverMessage,score),Toast.LENGTH_LONG)
            .show()
        resetGame()
    }
}