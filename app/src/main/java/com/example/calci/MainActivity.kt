package com.example.calci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginbutton: Button = findViewById(R.id.loginButton)
        loginbutton.setOnClickListener {
            loginToCalci(it)
        }
    }

    fun loginToCalci (view: View) {
        val plainText = findViewById<EditText>(R.id.username)
        val username = plainText.text.toString()
        val passWord = findViewById<EditText>(R.id.password)
        val password = passWord.text.toString()
        if( username == "student" && password == "mtap") {
            val intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "login failed, please try again", Toast.LENGTH_SHORT).show()
        }

    }

}