package com.example.a1117

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button

class fivefiveWallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fivefive_wall_window)

        val startButton = findViewById<Button>(R.id.startButton)
        val backButton = findViewById<Button>(R.id.backButton)

        startButton.setOnClickListener {
            val intent = Intent(this, resultActivity::class.java)

            val startYokoCoodinate = findViewById<EditText>(R.id.startYokoText).toString()
            val startTateCoodinate = findViewById<EditText>(R.id.startTateText).toString()
            val goalYokoCoodinate = findViewById<EditText>(R.id.goalYokoText).toString()
            val goalTateCoodinate = findViewById<EditText>(R.id.goalTateText).toString()

            val edittext00 = findViewById<EditText>(R.id.editText00).toString()
            val edittext01 = findViewById<EditText>(R.id.editText01).toString()
            val edittext02 = findViewById<EditText>(R.id.editText02).toString()
            val edittext03 = findViewById<EditText>(R.id.editText03).toString()
            val edittext04 = findViewById<EditText>(R.id.editText04).toString()
            val edittext10 = findViewById<EditText>(R.id.editText10).toString()
            val edittext11 = findViewById<EditText>(R.id.editText11).toString()
            val edittext12 = findViewById<EditText>(R.id.editText12).toString()
            val edittext13 = findViewById<EditText>(R.id.editText13).toString()
            val edittext14 = findViewById<EditText>(R.id.editText14).toString()
            val edittext20 = findViewById<EditText>(R.id.editText20).toString()
            val edittext21 = findViewById<EditText>(R.id.editText21).toString()
            val edittext22 = findViewById<EditText>(R.id.editText22).toString()
            val edittext23 = findViewById<EditText>(R.id.editText23).toString()
            val edittext24 = findViewById<EditText>(R.id.editText24).toString()
            val edittext30 = findViewById<EditText>(R.id.editText30).toString()
            val edittext31 = findViewById<EditText>(R.id.editText31).toString()
            val edittext32 = findViewById<EditText>(R.id.editText32).toString()
            val edittext33 = findViewById<EditText>(R.id.editText33).toString()
            val edittext34 = findViewById<EditText>(R.id.editText34).toString()
            val edittext40 = findViewById<EditText>(R.id.editText40).toString()
            val edittext41 = findViewById<EditText>(R.id.editText41).toString()
            val edittext42 = findViewById<EditText>(R.id.editText42).toString()
            val edittext43 = findViewById<EditText>(R.id.editText43).toString()
            val edittext44 = findViewById<EditText>(R.id.editText44).toString()

            intent.putExtra("startYoko", startYokoCoodinate)
            intent.putExtra("startTate", startTateCoodinate)
            intent.putExtra("goalYoko", goalYokoCoodinate)
            intent.putExtra("goalTate", goalTateCoodinate)

            intent.putExtra("wall00", edittext00)
            intent.putExtra("wall01", edittext01)
            intent.putExtra("wall02", edittext02)
            intent.putExtra("wall03", edittext03)
            intent.putExtra("wall04", edittext04)
            intent.putExtra("wall10", edittext10)
            intent.putExtra("wall11", edittext11)
            intent.putExtra("wall12", edittext12)
            intent.putExtra("wall13", edittext13)
            intent.putExtra("wall14", edittext14)
            intent.putExtra("wall20", edittext20)
            intent.putExtra("wall21", edittext21)
            intent.putExtra("wall22", edittext22)
            intent.putExtra("wall23", edittext23)
            intent.putExtra("wall24", edittext24)
            intent.putExtra("wall30", edittext30)
            intent.putExtra("wall31", edittext31)
            intent.putExtra("wall32", edittext32)
            intent.putExtra("wall33", edittext33)
            intent.putExtra("wall34", edittext34)
            intent.putExtra("wall40", edittext40)
            intent.putExtra("wall41", edittext41)
            intent.putExtra("wall42", edittext42)
            intent.putExtra("wall43", edittext43)
            intent.putExtra("wall44", edittext44)

            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, startWindowActivity::class.java)
            startActivity(intent)
        }
    }
}


