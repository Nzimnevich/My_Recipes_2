package com.example.myrecipes.enums

import com.example.myrecipes.R

enum class Meals {
    BREAKFAST,BRUNCH,LUNCH,DINNER
}
fun getNameForMeals(meal: Meals): Int {
    return when (meal) {
        Meals.BREAKFAST -> R.string.breakfast
        Meals.BRUNCH -> R.string.brunch
        Meals.LUNCH -> R.string.lunch
        Meals.DINNER -> R.string.dinner

    }
}