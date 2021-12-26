package com.example.myrecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrationActivity : AppCompatActivity() {
   lateinit var  tiet_Name: TextInputEditText
   lateinit var til_Name: TextInputLayout
    lateinit var  tiet_Email: TextInputEditText
    lateinit var til_Email: TextInputLayout
    lateinit var  tiet_Password: TextInputEditText
    lateinit var til_Password: TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        tiet_Name = findViewById(R.id.name)
        til_Name = findViewById(R.id.tf_name)

        tiet_Name.addTextChangedListener {
            if (it.toString().length < 5) {
                til_Name.error = "Указаное имя меньше 5ти символов!"
            }
            else {
                til_Name.error ="" //Можно ли тут обрабатывать по другому? вместо error  ставить что-то другое? не факт, что эт интуитивно понятно
            }
        }


        tiet_Email = findViewById(R.id.email)
        til_Email = findViewById(R.id.tf_email)

        tiet_Email.addTextChangedListener {
            if (!isEmailValid(it.toString())  and (it.toString().length<5)) {
                til_Email.error ="Указанный email должен быть больше 5ти символов и иметь @"
            }
            else {
                til_Email.error =""
            }
        }

        tiet_Password = findViewById(R.id.password)
        til_Password = findViewById(R.id.tf_password)

        tiet_Password.addTextChangedListener {
            if (it.toString().length < 6) {
                til_Password.error = "Указаный пароль меньше 6ти символов!"
            }
            else {
                til_Password.error =""
            }
        }



        var buttonAuth = findViewById<Button>(R.id.btn_return_auto)
        buttonAuth.setOnClickListener {
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isEmailValid(email: String): Boolean {
    return email.contains("@")

    }

}