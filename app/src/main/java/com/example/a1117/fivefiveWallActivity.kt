package com.example.a1117

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
//import kotlinx.android.synthetic.main.fivefive_window.*

class fivefiveWallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fivefive_wall_window)
    }

    fun onbuttonClick(view: View) {
        val intent = Intent(this, resultActivity::class.java)

        val edittext00 = findViewById<EditText>(R.id.editText00)
        val edittext01 = findViewById<EditText>(R.id.editText01)
        val edittext02 = findViewById<EditText>(R.id.editText02)
        val edittext03 = findViewById<EditText>(R.id.editText03)
        val edittext04 = findViewById<EditText>(R.id.editText04)
        val edittext10 = findViewById<EditText>(R.id.editText10)
        val edittext11 = findViewById<EditText>(R.id.editText11)
        val edittext12 = findViewById<EditText>(R.id.editText12)
        val edittext13 = findViewById<EditText>(R.id.editText13)
        val edittext14 = findViewById<EditText>(R.id.editText14)
        val edittext20 = findViewById<EditText>(R.id.editText20)
        val edittext21 = findViewById<EditText>(R.id.editText21)
        val edittext22 = findViewById<EditText>(R.id.editText22)
        val edittext23 = findViewById<EditText>(R.id.editText23)
        val edittext24 = findViewById<EditText>(R.id.editText24)
        val edittext30 = findViewById<EditText>(R.id.editText30)
        val edittext31 = findViewById<EditText>(R.id.editText31)
        val edittext32 = findViewById<EditText>(R.id.editText32)
        val edittext33 = findViewById<EditText>(R.id.editText33)
        val edittext34 = findViewById<EditText>(R.id.editText34)
        val edittext40 = findViewById<EditText>(R.id.editText40)
        val edittext41 = findViewById<EditText>(R.id.editText41)
        val edittext42 = findViewById<EditText>(R.id.editText42)
        val edittext43 = findViewById<EditText>(R.id.editText43)
        val edittext44 = findViewById<EditText>(R.id.editText44)

        val startYokoCoodinate: Int = findViewById<EditText>(R.id.startYokoText).toString().toInt()
        val startTateCoodinate: Int = findViewById<EditText>(R.id.startTateText).toString().toInt()
        val goalYokoCoodinate: Int = findViewById<EditText>(R.id.goalYokoText).toString().toInt()
        val goalTateCoodinate: Int = findViewById<EditText>(R.id.goalTateText).toString().toInt()

        intent.putExtra("wall00", edittext00.toString())
        intent.putExtra("wall01", edittext01.toString())
        intent.putExtra("wall02", edittext02.toString())
        intent.putExtra("wall03", edittext03.toString())
        intent.putExtra("wall04", edittext04.toString())
        intent.putExtra("wall10", edittext10.toString())
        intent.putExtra("wall11", edittext11.toString())
        intent.putExtra("wall12", edittext12.toString())
        intent.putExtra("wall13", edittext13.toString())
        intent.putExtra("wall14", edittext14.toString())
        intent.putExtra("wall20", edittext20.toString())
        intent.putExtra("wall21", edittext21.toString())
        intent.putExtra("wall22", edittext22.toString())
        intent.putExtra("wall23", edittext23.toString())
        intent.putExtra("wall24", edittext24.toString())
        intent.putExtra("wall30", edittext30.toString())
        intent.putExtra("wall31", edittext31.toString())
        intent.putExtra("wall32", edittext32.toString())
        intent.putExtra("wall33", edittext33.toString())
        intent.putExtra("wall34", edittext34.toString())
        intent.putExtra("wall40", edittext40.toString())
        intent.putExtra("wall41", edittext41.toString())
        intent.putExtra("wall42", edittext42.toString())
        intent.putExtra("wall43", edittext43.toString())
        intent.putExtra("wall44", edittext44.toString())

        intent.putExtra("startYoko", startYokoCoodinate.toString())
        intent.putExtra("startTate", startTateCoodinate.toString())
        intent.putExtra("goalYoko", goalYokoCoodinate.toString())
        intent.putExtra("goalTate", goalTateCoodinate.toString())

        startActivity(intent)
    }

    fun onbuttonTapped(view: View) {
        val intent = Intent(this, startWindowActivity::class.java)
        startActivity(intent)
    }
}

