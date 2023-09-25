package com.example.shere_prefrience

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)
        val save = findViewById<Button>(R.id.save)
        val show = findViewById<Button>(R.id.show)
        val share = findViewById<Button>(R.id.share)

        val localstorage = getSharedPreferences("user",Context.MODE_PRIVATE)
        save.setOnClickListener {
            val editPref = localstorage.edit()

            editPref.putString("username", name.text.toString())
            editPref.putString("useremail",email.text.toString()).apply()
        }
        show.setOnClickListener {
           val getname = localstorage.getString("username","name not found")
            val getemail = localstorage.getString("useremail","email not found")
            Toast.makeText(this,"$getname",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"$getemail",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,Home_Activity::class.java)
            startActivity(intent)
        }
        share.setOnClickListener {
            val editPref = localstorage.edit()
            editPref.clear()
            editPref.apply()
        }

    }

}