package com.example.myrecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.myrecipes.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val buttonFullRecipe:ImageButton by lazy{binding.recipe1Ibtn}
    private val buttonFilters: ImageButton by lazy{binding.filtersIbtn}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.d("This is log for on Create")


        buttonFullRecipe.setOnClickListener {
            val intent = Intent(this, FullRecipeActivity::class.java)
            startActivity(intent)
        }

        buttonFilters.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }
    }
}