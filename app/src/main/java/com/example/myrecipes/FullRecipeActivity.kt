package com.example.myrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FullRecipeActivity : AppCompatActivity() {
    private var fakeFoodRepository = FakeFoodRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_recipe)


    }


    fun setRecipe(recipe:Recipe){

    }


    fun setInformRecipe(id: Int): Recipe {
        return fakeFoodRepository.sortRecipeById(id)
    }
}