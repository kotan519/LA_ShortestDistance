package com.example.a1117

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class startWindowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_window)
    }

    fun onbutton5Click(view: View) {
        val intent = Intent(this, fivefiveWallActivity :: class.java)
        startActivity(intent)
    }
}

