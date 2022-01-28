package com.example.myrecipes.enums

import com.example.myrecipes.R

enum class Ingredient() {

    SUGAR,
    BUTTER,
    EGG,
    WATER,
    STRAWBERRY,
    BLUEBERRY;

}

fun getPicturesForIngredients(ingredient: Ingredient): Int {
    return when (ingredient) {
        Ingredient.SUGAR -> R.drawable.ic_spoon
        Ingredient.BUTTER -> R.drawable.ic_butter
        Ingredient.EGG -> R.drawable.ic_eggs
        Ingredient.WATER -> R.drawable.ic_glasses
        Ingredient.STRAWBERRY -> R.drawable.ic_strawberries
        Ingredient.BLUEBERRY -> R.drawable.ic_berry
    }
}