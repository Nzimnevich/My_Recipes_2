package com.example.myrecipes

import androidx.annotation.DrawableRes
import com.example.myrecipes.enums.Ingredient

class FoodUtils {
    @DrawableRes
    fun resolveFoodIngredient(ingredient: Ingredient): Int {
        @DrawableRes
        var id = 0
        when (ingredient) {
            Ingredient.BLUEBERRY -> id = R.drawable.ic_berry
            Ingredient.STRAWBERRY -> id = R.drawable.ic_strawberries
            Ingredient.WATER -> id = R.drawable.ic_glasses
            Ingredient.EGG -> R.drawable.ic_eggs
            Ingredient.BUTTER -> R.drawable.ic_butter
            Ingredient.SUGAR -> R.drawable.ic_spoon
        }
        return id
    }


    @DrawableRes
    fun resolveFoodImg(img: String): Int {
        @DrawableRes
        var id = 0
        when (img) {
            "ic_french_toasts" -> id = R.drawable.ic_french_toasts
            "ic_maffin" -> id = R.drawable.ic_maffin
            "ic_glazed_salmon" -> id = R.drawable.ic_glazed_salmon
            "ic_azia_glazet_chiken" -> id = R.drawable.ic_azia_glazet_chiken
            "ic_toasts_with_cinnamon" -> id = R.drawable.ic_toasts_with_cinnamon

        }
        return id
    }
}