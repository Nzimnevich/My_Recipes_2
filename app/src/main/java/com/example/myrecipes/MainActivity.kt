package com.example.myrecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("This is log for on Create")

        var buttonFullRecipe:ImageButton = findViewById(R.id.recipe1_ibtn)
        buttonFullRecipe.setOnClickListener {
            val intent = Intent(this, FullRecipeActivity::class.java)
            startActivity(intent)
        }
    }
}