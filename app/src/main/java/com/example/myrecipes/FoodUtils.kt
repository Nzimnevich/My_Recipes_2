package com.example.myrecipes

import com.example.myrecipes.enums.Ingredient

class FoodUtils {
    fun resolveFoodIngredient(ingredient: Ingredient): Int {
        var id: Int = 0
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