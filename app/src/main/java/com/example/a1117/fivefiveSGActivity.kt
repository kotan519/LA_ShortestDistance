package com.example.a1117

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.EditText
import android.widget.Button
//import kotlinx.android.synthetic.main.fivefive_window.*

class fivefiveSGActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fivefive_sg_window)

        val startYokoCoodinate : Int = findViewById<EditText>(R.id.startYokoText).toString().toInt()
        val startTateCoodinate : Int = findViewById<EditText>(R.id.startTateText).toString().toInt()
        val goalYokoCoodinate : Int = findViewById<EditText>(R.id.goalYokoText).toString().toInt()
        val goalTateCoodinate : Int = findViewById<EditText>(R.id.goalTateText).toString().toInt()


        val startbutton = findViewById<Button>(R.id.startButton)
        val backbutton = findViewById<Button>(R.id.backButton)

        startbutton.setOnClickListener {
            val intent = Intent(this, resultActivity::class.java)

            intent.putExtra("startYoko",startYokoCoodinate.toString())
            intent.putExtra("startTate",startTateCoodinate.toString())
            intent.putExtra("goalYoko",goalYokoCoodinate.toString())
            intent.putExtra("goalTate",goalTateCoodinate.toString())

            startActivity(intent)

        }

        backbutton.setOnClickListener {
            val intent = Intent(this,fivefiveWallActivity::class.java)
            startActivity(intent)
        }



    }
}