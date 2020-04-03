package com.example.lektion2android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

val EXTRA_MESSAGE = "com.example.Lektion2Android.MESSAGE"

class MainActivity : AppCompatActivity() {

        lateinit var questionView : TextView
        var firstNumber = 0
        var secondNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionView = findViewById(R.id.questionText)
        randomizeQuestion()

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            startAnswerActivity()
        }

    }

    override fun onRestart() {
        super.onRestart()

        randomizeQuestion()
    }

    fun checkAnswer() : Boolean {
        val answerText = findViewById<EditText>(R.id.answerText)
        val answer = answerText.text.toString()
        val answerInt = answer.toIntOrNull()

        return firstNumber + secondNumber == answerInt
    }

    fun startAnswerActivity() {
        val rightAnswer = checkAnswer()
        intent.putExtra(EXTRA_MESSAGE, rightAnswer)
        val intent = Intent(this, AnswerActivity::class.java)
        startActivity(intent)
    }


    fun randomizeQuestion() {
        firstNumber = (1..10).random()
        secondNumber = (1..10).random()
        questionView.text = "$firstNumber + $secondNumber ="
    }


}
