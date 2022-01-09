package com.example.a1117

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

//import kotlinx.android.synthetic.main.fivefive_window.*

class fivefiveAnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fivefive_answer_window)

        val UnCorrectResult = intent.getStringExtra("UnCorrectResult")
        val CorrectResult = intent.getStringExtra("CorrectResult")
        val Answer : String? = intent.getStringExtra("answer")

        val AnswerText = findViewById<TextView>(R.id.answerText)
        val CorrectAnswer = findViewById<TextView>(R.id.correctAnswer)

        if (UnCorrectResult == "Unreached"){
            AnswerText.setText("到達できません")
        }
        else if(CorrectResult == Answer){
            AnswerText.setText("正解です。")
        }else{
            AnswerText.setText("不正解です。")
            CorrectAnswer.setText("正解は${CorrectResult}です。")
        }

        val returnstartbutton = findViewById<Button>(R.id.returnStartButton)

        returnstartbutton.setOnClickListener{
            val intent = Intent(this,startWindowActivity::class.java)
            startActivity(intent)
        }
    }

}