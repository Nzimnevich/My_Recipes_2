
package com.example.myrecipes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import com.example.myrecipes.databinding.ActivityRegistrationBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

//todo доделать вариант с отображением в полях символа 0
class RegistrationActivity : AppCompatActivity() {

    companion object Const{
        const val MAX_FOR_PASSWORD = 6
        const val MAX_FOR_EMAIL = 5
        const val MAX_FOR_NAME = 5

        fun start(context: Context) {
            val intent = Intent(context, RegistrationActivity::class.java)
            context.startActivity(intent)
        }
    }
    private lateinit var binding: ActivityRegistrationBinding
    private val nameTiet: TextInputEditText by lazy{ binding.nameTiet}
    private val nameTil: TextInputLayout by lazy{ binding.nameTil}
    private val emailTiet: TextInputEditText by lazy{binding.emailTiet}
    private val emailTil: TextInputLayout by lazy{ binding.emailTil}
    private val passwordTiet: TextInputEditText by lazy{ binding.passwordTiet}
    private val passwordTil: TextInputLayout by lazy{ binding.passwordTil}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        nameTiet.addTextChangedListener {
            var pluralsInform = resources.getQuantityString(
                R.plurals.plurals_for_count_of_characters,
                MAX_FOR_NAME,
                MAX_FOR_NAME
            )
            if (it.toString().length < MAX_FOR_NAME) {
                nameTil.error = String.format(
                    resources.getString(R.string.message_about_wrong_name),
                    MAX_FOR_EMAIL
                ) + pluralsInform
            } else {
                emailTil.error = ""
            }
        }

        emailTiet.addTextChangedListener {

            var pluralsInform = resources.getQuantityString(
                R.plurals.plurals_for_count_of_characters,
                MAX_FOR_EMAIL,
                MAX_FOR_EMAIL
            )

            if (!isEmailValid(it.toString()) and (it.toString().length < MAX_FOR_EMAIL)) {
                emailTil.error = String.format(
                    resources.getString(R.string.message_about_wrong_email),
                    MAX_FOR_EMAIL
                ) + pluralsInform
            } else {
                emailTil.error = ""
            }
        }

        passwordTiet.addTextChangedListener {

            var pluralsInform = resources.getQuantityString(
                R.plurals.plurals_for_count_of_characters,
                MAX_FOR_PASSWORD,
                MAX_FOR_PASSWORD
            )
            if (it.toString().length < MAX_FOR_NAME) {
                passwordTil.error = String.format(
                    resources.getString(R.string.message_about_wrong_password),
                    MAX_FOR_EMAIL
                ) + pluralsInform
            } else {
                emailTil.error = ""
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



