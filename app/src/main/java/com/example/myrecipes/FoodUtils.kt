package com.example.myrecipes

import androidx.annotation.DrawableRes
import com.example.myrecipes.enums.Ingredient

class FoodUtils {
    @DrawableRes
    fun resolveFoodIngredient(ingredient: Ingredient): Int {
        var id = 0
        when (ingredient) {
            Ingredient.BLUEBERRY -> id = R.drawable.ic_berry
            Ingredient.STRAWBERRY -> id = R.drawable.ic_strawberries
            Ingredient.WATER ->id= R.drawable.ic_glasses
            Ingredient.EGG ->R.drawable.ic_eggs
            Ingredient.BUTTER ->R.drawable.ic_butter
            Ingredient.SUGAR ->R.drawable.ic_spoon
        }
        return id
    }
}