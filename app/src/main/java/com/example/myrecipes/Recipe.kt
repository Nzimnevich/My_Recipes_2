package com.example.myrecipes

import com.example.myrecipes.enums.Dishes
import com.example.myrecipes.enums.Ingredient
import com.example.myrecipes.enums.Meals

data class Recipe(val number:Int,val name: String, val meals: Meals,val typeOfDish:Dishes, val indigrients: ArrayList<Ingredient>, val time:Long, val cal:Int, val listOfSteps:ArrayList<String>, val isLike:Boolean, val stars: Int, val imgLinks:String, val countServings:Int) {
    var id =number
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