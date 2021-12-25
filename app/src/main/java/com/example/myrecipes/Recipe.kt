package com.example.myrecipes

import com.example.myrecipes.enums.Dishes
import com.example.myrecipes.enums.Ingredient
import com.example.myrecipes.enums.Meals

data class Recipe(val name: String, val meals: Meals,val typeOfDish:Dishes, val indigrients: Set<Ingredient>, val time:Long, val cal:Int, val listOfSteps:Set<String>, val isLike:Boolean, val stars: Int, val imgLinks:String, val countServings:Int) {
    var title = name
    var category = meals
    var dishes = typeOfDish
    var listIndigrients = indigrients
    var timeToCook = time
    var calories = cal
    var listSteps = listOfSteps
    var beLike = isLike
    var rating = stars
    var imageLink = imgLinks
    var numberOfServings = countServings
}