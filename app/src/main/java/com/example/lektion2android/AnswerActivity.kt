package com.example.lektion2android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val answer = intent.getBooleanExtra(EXTRA_MESSAGE, false)

        val textView = findViewById<TextView>(R.id.answer)

        textView.text = if (answer) {
            "Rätt svar"
        } else {
            "Fel svar"
        }

    }
}
