package com.example.classexample1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ColorizeMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colorize_message)

        val rootView = window.decorView.rootView
        val messageView = findViewById<TextView>(R.id.message)

        val propsColor = intent.extras?.getInt("color") ?: Color.GRAY
        val propsMessage = intent.extras?.getString("message") ?: ""

        rootView.setBackgroundColor(propsColor)
        messageView.text = propsMessage
    }
}