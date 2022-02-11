package com.example.myrecipes

import com.example.myrecipes.enums.Dishes
import com.example.myrecipes.enums.Ingredient
import com.example.myrecipes.enums.Meals
import com.example.myrecipes.ui.search.FilterHolder

class FakeFoodRepository {

    private val frenchToasts = Recipe(
        1,
        "Французские тосты с клубникой",
        Meals.BREAKFAST,
        Dishes.DESSERT,
        arrayListOf(
            Ingredient.SUGAR,
            Ingredient.BUTTER,
            Ingredient.WATER,
            Ingredient.EGG,
            Ingredient.STRAWBERRY,
            Ingredient.BLUEBERRY
        ),
        15,
        450,
        arrayListOf("шаг 1", "шаг 2", "шаг 3", "шаг 4"),
        true,
        3F,
        "ic_french_toasts",
        2
    )
    private val toastsWithCinnamon = Recipe(
        2,
        "Тосты с корицей и сахаром",
        Meals.BREAKFAST,
        Dishes.DESSERT,
        arrayListOf(
            Ingredient.SUGAR,
            Ingredient.BUTTER,
            Ingredient.WATER,
            Ingredient.EGG,
            Ingredient.STRAWBERRY,
            Ingredient.BLUEBERRY
        ),
        15,
        350,
        arrayListOf("шаг 1", "шаг 2", "шаг 3"),
        false,
        5F,
        "ic_toasts_with_cinnamon",
        3
    )
    private val blueberryMuffins = Recipe(
        3,
        "Черничные маффины",
        Meals.BRUNCH,
        Dishes.SNACK,
        arrayListOf(
            Ingredient.SUGAR,
            Ingredient.BUTTER,
            Ingredient.WATER,
            Ingredient.EGG,
            Ingredient.BLUEBERRY
        ),
        45,
        210,
        arrayListOf("шаг 1"),
        false,
        2F,
        "ic_maffin",
        7
    )
    val glazedSalmon = Recipe(
        4,
        "Ласось в глазури",
        Meals.DINNER,
        Dishes.MAIN_COURSE,
        arrayListOf(),
        60,
        300,
        arrayListOf("шаг 1", "шаг 2", "шаг 3", "шаг 4"),
        true,
        4F,
        "ic_glazed_salmon",
        1
    )
    private val asianGlazedChicken = Recipe(
        5,
        "Asian Glazed Chicken Things",
        Meals.LUNCH,
        Dishes.MEAT_DISH,
        arrayListOf(),
        90,
        500,
        arrayListOf("шаг 1"),
        false,
        1F,
        "ic_azia_glazet_chiken",
        5
    )

    fun returnAllRecipes(): List<Recipe> {
        return listOf(
            frenchToasts,
            toastsWithCinnamon,
            blueberryMuffins,
            glazedSalmon,
            asianGlazedChicken
        )
    }

    fun sortRecipesByRating(isAscendingOrder: Boolean): List<Recipe> {
        val list: List<Recipe> = returnAllRecipes()
        return if (isAscendingOrder) {
            list.sortedBy { it.rating }.toList()
        } else {
            list.sortedByDescending { it.rating }.toList()
        }
    }

    fun sortRecipesByTypeOfMeals(meals: Meals): List<Recipe> {
        return returnAllRecipes().filter { it.meals == meals }
    }

    fun sortRecipesByCategoryOfDishes(dish: Dishes): List<Recipe> {
        return returnAllRecipes().filter { it.typeOfDish == dish }
    }

    fun sortRecipesByCountCalories(moreCalories: Boolean, countCalories: Int): List<Recipe> {
        return if (moreCalories) {
            returnAllRecipes().filter { it.calories > countCalories }
        } else {
            returnAllRecipes().filter { it.calories < countCalories }
        }
    }

    fun sortRecipesByTime(time: Int): List<Recipe> {
        return returnAllRecipes().filter { it.time <= time }
    }

    fun sortRecipeById(id: Int): Recipe {
        return returnAllRecipes().filter { it.id == id }.get(0)
    }


    fun sortRecipe(filterHolder: FilterHolder): List<Recipe> {
        var list: List<Recipe> = returnAllRecipes()
        list = list.
//        filter { it.timeToCook <= filterHolder.selectedTimeToCook }.
//        filter { it.rating == filterHolder.selectedRating }.
        filter { it.dishes.toString().equals(filterHolder.selectedDish)}
            //   filter { it.meals.equals(filterHolder.selectedMeals)}
    println("***")
        println(filterHolder.selectedDish)

//        it.dishes.valueOf("Foo") == MyEnum.Foo
            return list

    }




}