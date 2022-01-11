package com.example.myrecipes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

//todo доделать вариант с отображением в полях символа 0
class RegistrationActivity : AppCompatActivity() {

    companion object Const{
        const val MAX_FOR_PASSWORD = 6
        const val MAX_FOR_EMAIL = 5
        const val MAX_FOR_NAME = 5
    }

    private val tietName: TextInputEditText by lazy { findViewById(R.id.name_tiet) }
    private val tilName: TextInputLayout by lazy { findViewById(R.id.name_tf) }
    private val tietEmail: TextInputEditText by lazy { findViewById(R.id.email_tiet) }
    private val tilEmail: TextInputLayout by lazy { findViewById(R.id.email_tf) }
    private val tietPassword: TextInputEditText by lazy { findViewById(R.id.password_tiet) }
    private val tilPassword: TextInputLayout by lazy { findViewById(R.id.password_tf) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        tietName.addTextChangedListener {
            var pluralsInform = resources.getQuantityString(
                R.plurals.plurals_for_count_of_characters,
                MAX_FOR_NAME,
                MAX_FOR_NAME
            )
            if (it.toString().length < MAX_FOR_NAME) {
                tilName.error = String.format(
                    resources.getString(R.string.message_about_wrong_name),
                    MAX_FOR_EMAIL
                ) + pluralsInform
            } else {
                tilEmail.error = ""
            }
        }

        tietEmail.addTextChangedListener {

            var pluralsInform = resources.getQuantityString(
                R.plurals.plurals_for_count_of_characters,
                MAX_FOR_EMAIL,
                MAX_FOR_EMAIL
            )

            if (!isEmailValid(it.toString()) and (it.toString().length < MAX_FOR_EMAIL)) {
                tilEmail.error = String.format(
                    resources.getString(R.string.message_about_wrong_email),
                    MAX_FOR_EMAIL
                ) + pluralsInform
            } else {
                tilEmail.error = ""
            }
        }

        tietPassword.addTextChangedListener {

            var pluralsInform = resources.getQuantityString(
                R.plurals.plurals_for_count_of_characters,
                MAX_FOR_PASSWORD,
                MAX_FOR_PASSWORD
            )
            if (it.toString().length < MAX_FOR_NAME) {
                tilPassword.error = String.format(
                    resources.getString(R.string.message_about_wrong_password),
                    MAX_FOR_EMAIL
                ) + pluralsInform
            } else {
                tilEmail.error = ""
            }
        }

        var buttonAuth = findViewById<Button>(R.id.return_auto_btn)
        buttonAuth.setOnClickListener {
            AuthorizationActivity.start(this)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}



