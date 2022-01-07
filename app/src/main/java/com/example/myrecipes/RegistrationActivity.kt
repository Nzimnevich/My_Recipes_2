package com.example.myrecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrationActivity : AppCompatActivity() {
    private val tiet_Name: TextInputEditText by lazy { findViewById(R.id.name_tiet) }
    private val til_Name: TextInputLayout by lazy { findViewById(R.id.name_tf) }
    private val tiet_Email: TextInputEditText by lazy { findViewById(R.id.email_tiet) }
    private val til_Email: TextInputLayout by lazy { findViewById(R.id.email_tf) }
    private val tiet_Password: TextInputEditText by lazy { findViewById(R.id.password_tiet) }
    private val til_Password: TextInputLayout by lazy { findViewById(R.id.password_tf) }

    private val countForNameAndEmail = 5
    private val countForPassword = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)



        tiet_Name.addTextChangedListener {
            if (it.toString().length < countForNameAndEmail) {
                til_Name.error = String.format(
                    resources.getString(R.string.message_about_wrong_name),
                    countForNameAndEmail
                )
            } else {
                til_Name.error = ""
            }
        }


        tiet_Email.addTextChangedListener {
            if (!isEmailValid(it.toString()) and (it.toString().length < countForNameAndEmail)) {
                til_Email.error = String.format(
                    resources.getString(R.string.message_about_wrong_email),
                    countForNameAndEmail
                )
            } else {
                til_Email.error = ""
            }
        }

        tiet_Password.addTextChangedListener {
            if (it.toString().length < countForPassword) {
                til_Password.error = String.format(
                    resources.getString(R.string.message_about_wrong_password),
                    countForPassword
                )
            } else {
                til_Password.error = ""
            }
        }


        var buttonAuth = findViewById<Button>(R.id.return_auto_btn)
        buttonAuth.setOnClickListener {
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }

}