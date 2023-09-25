package com.example.shere_prefrience

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Home_Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val localstorage = getSharedPreferences("user", Context.MODE_PRIVATE)

        val getname = localstorage.getString("username","name not found")
        val getemail = localstorage.getString("useremail","email not found")

        val name1 = findViewById<TextView>(R.id.text1)
        val email2 = findViewById<TextView>(R.id.text2)

        name1.text = getname.toString()
        email2.text = getemail.toString()

        Toast.makeText(this,"$getname", Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"$getemail", Toast.LENGTH_SHORT).show()



    }
}