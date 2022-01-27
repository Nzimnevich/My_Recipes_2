package com.example.myrecipes

import com.example.myrecipes.enums.Dishes
import com.example.myrecipes.enums.Meals
import org.jetbrains.annotations.TestOnly

class FakeFoodRepository {
    private val frenchToasts = Recipe(1,"Французские тосты с клубникой", Meals.BREAKFAST,Dishes.DESSERT ,linkedSetOf(),15,450,linkedSetOf(),true,3,"drawable/ic_french_toasts.png",2)
    private val toastsWithCinnamon = Recipe(2,"Тосты с корицей и сахаром", Meals.BREAKFAST,Dishes.DESSERT ,linkedSetOf(),15,350,linkedSetOf(),false,5,"drawable/ic_toasts_with_cinnamon.png",3)
    private val blueberryMuffins = Recipe(3,"Черничные маффины", Meals.BRUNCH,Dishes.SNACK,linkedSetOf(),45,210,linkedSetOf(),false,2,"drawable/ic_maffin.png",7)
    val glazedSalmon = Recipe(4,"Ласось в глазури", Meals.DINNER, Dishes.MAIN_COURSE,linkedSetOf(),60,300,linkedSetOf(),true,4,"drawable/ic_glazed_salmon.png",1)
    private val asianGlazedChicken = Recipe(5,"Asian Glazed Chicken Things",Meals.LUNCH,Dishes.MEAT_DISH, linkedSetOf(),90,500,linkedSetOf(),false,1,"drawable/ic_azia_glazet_chiken.png",5)

    fun returnAllRecipes(): List<Recipe> {
        return listOf<Recipe>(frenchToasts,toastsWithCinnamon,blueberryMuffins,glazedSalmon,asianGlazedChicken)
    }

    fun sortRecipesByRating(isAscendingOrder:Boolean ):List<Recipe>{
        val list: List<Recipe> = returnAllRecipes()
        return if (isAscendingOrder) {
            list.sortedBy { it.rating }.toList()
        } else {
            list.sortedByDescending { it.rating }.toList()
        }
     }

    fun sortRecipesByTypeOfMeals(meals: Meals):List<Recipe>{
        return returnAllRecipes().filter { it.meals==meals }
    }

    fun sortRecipesByCategoryOfDishes(dish: Dishes):List<Recipe>{
        return returnAllRecipes().filter { it.typeOfDish==dish}
    }

    fun sortRecipesByCountCalories(moreCalories:Boolean,countCalories:Int):List<Recipe>{
        return if (moreCalories) {
            returnAllRecipes().filter { it.calories > countCalories }
        } else {
            returnAllRecipes().filter { it.calories < countCalories }
        }
    }

    fun sortRecipesByTime(time:Int):List<Recipe>{
        return returnAllRecipes().filter { it.time<=time }
    }

    fun sortRecipeById(id:Int):Recipe{
        return  returnAllRecipes().filter{it.id ==id}.get(0)
    }

}