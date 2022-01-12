package com.example.myrecipes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myrecipes.databinding.ActivityFilterBinding
import com.example.myrecipes.databinding.ActivityWelcomeBinding
import timber.log.Timber

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.d("This is log for on Create")

        val buttonAuto = binding.loginBtn
        val buttonRegistration = binding.registrationBtn

        buttonAuto.setOnClickListener(this)
        buttonRegistration.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.login_btn -> AuthorizationActivity.start(this)
            R.id.registration_btn -> RegistrationActivity.start(this)
        }
    }


}