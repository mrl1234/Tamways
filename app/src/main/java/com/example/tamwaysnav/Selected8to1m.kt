package com.example.tamwaysnav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Selected8to1m : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected8to1m)

        val MainActbutton =findViewById<Button>(R.id.button2)
        MainActbutton.setOnClickListener {
            val Intent = Intent(this,Selected8to1n::class.java)
            startActivity(Intent)
        }
    }
}