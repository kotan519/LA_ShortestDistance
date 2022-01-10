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

        //val UnCorrectResult = intent.getStringExtra("UnCorrectResult")
        //val CorrectResult = intent.getIntExtra("CorrectResult",0)
        val Answer = intent.getIntExtra("answer",1)

        val AnswerText = findViewById<TextView>(R.id.answerText)
        val CorrectAnswer = findViewById<TextView>(R.id.correctAnswer)

        val ffResultAct = resultOfAlgorithm.getInstance()

        if (ffResultAct.UnCorrectResult == "Unreached"){
            AnswerText.setText("到達できません")
        }
        else if(ffResultAct.CorrectResult == Answer){
            AnswerText.setText("正解です。")
        }else{
            AnswerText.setText("不正解です。")
            CorrectAnswer.setText("正解は${ffResultAct.CorrectResult}です。")
        }

        val returnstartbutton = findViewById<Button>(R.id.returnStartButton)

        returnstartbutton.setOnClickListener{
            val intent = Intent(this,startWindowActivity::class.java)
            startActivity(intent)
        }
    }
}





















