package com.example.classexample1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var messageView: EditText
    private lateinit var spinner: Spinner

    private var selectedColor = null as String?

    private val colors = hashMapOf(
        "yellow" to Color.YELLOW,
        "green" to Color.GREEN
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        messageView = findViewById(R.id.message_input)

        initializeSpinner()
    }

    @Suppress("UNUSED_PARAMETER")
    fun navigateToColorize(view: View) {
        val message = messageView.text.toString()
        when {
            selectedColor.isNullOrBlank() -> {
                Toast.makeText(this@MainActivity, "You must selected a color", Toast.LENGTH_SHORT)
                    .show()
            }
            message.isBlank() -> {
                Toast.makeText(this@MainActivity, "Your message in empty", Toast.LENGTH_SHORT)
                    .show()
            }
            else -> {
                val intent = Intent(this, ColorizeMessageActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("color", colors[selectedColor] ?: Color.GRAY)
                bundle.putString("message", message)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun initializeSpinner() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors.keys.toList())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedColor = parent.getItemAtPosition(position) as String
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedColor = null
            }
        }
    }
}