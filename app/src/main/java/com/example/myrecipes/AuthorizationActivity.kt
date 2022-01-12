package com.example.myrecipes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        val button = findViewById<Button>(R.id.enter_btn)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonRegistration = findViewById<Button>(R.id.return_reg_btn)
        buttonRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }


    companion object {

        fun start(context: Context) {
            val intent = Intent(context, AuthorizationActivity::class.java)
            context.startActivity(intent)
        }
    }
}