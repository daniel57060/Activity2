package com.example.classexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0

        val elCount = findViewById<TextView>(R.id.count)
        val btnClickHere = findViewById<Button>(R.id.click_here)

        btnClickHere.setOnClickListener {
            Log.d("INFO", "$counter")
            counter += 1
            elCount.text = counter.toString()
        }
    }
}