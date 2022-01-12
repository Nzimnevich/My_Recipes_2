package com.example.myrecipes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myrecipes.databinding.ActivityAuthorizationBinding

class AuthorizationActivity : AppCompatActivity() {
    companion object {

        fun start(context: Context) {
            val intent = Intent(context, AuthorizationActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityAuthorizationBinding
    private val enterButton:Button by lazy { binding.enterBtn}
    private val registrationBtn:Button by lazy { binding.returnRegBtn}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enterButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        registrationBtn.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}