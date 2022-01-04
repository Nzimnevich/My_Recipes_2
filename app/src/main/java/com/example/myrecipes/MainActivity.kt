package com.example.myrecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.inflate
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("This is log for on Create")

        var button_full_recipe:ImageButton = findViewById(R.id.ib_recipe1)
        button_full_recipe.setOnClickListener {
            val intent = Intent(this, FullRecipe::class.java)
            startActivity(intent)
        }
    }
}