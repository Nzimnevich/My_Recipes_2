package com.example.myrecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import timber.log.Timber

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        Timber.d("This is log for on Create")

        val buttonAuto = findViewById<Button>(R.id.login_btn)
        val buttonRegistration = findViewById<Button>(R.id.registration_btn)

        buttonAuto.setOnClickListener (this)
        buttonRegistration.setOnClickListener (this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.login_btn -> AuthorizationActivity.start(this)
            R.id.registration_btn->startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }


}