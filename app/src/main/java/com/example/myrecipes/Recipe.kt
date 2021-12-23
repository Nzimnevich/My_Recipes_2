package com.example.myrecipes

import com.example.myrecipes.enums.Dishes
import com.example.myrecipes.enums.Ingredient
import com.example.myrecipes.enums.Meals

//конструктор из 10 параметров, это конечно "обнять и плакать" >.<
data class Recipe(var name: String, var meals: Meals,var typeOfDish:Dishes, var indigrients: Set<Ingredient>, var time:Long, var cal:Int, var listOfSteps:Set<String>, var isLike:Boolean, var stars: Int, var imgLinks:String, var countServings:Int) {
    var title = name
    var category = meals
    var dishes=typeOfDish
    var listIndigrients=indigrients
    var timeToCook=time
    var calories=cal
    var listSteps=listOfSteps
    var beLike=isLike
    var rating: Int = if ((stars < 1) or (stars > 5)) 1 else stars
    var imageLink=imgLinks
    var numberOfServings=countServings
}