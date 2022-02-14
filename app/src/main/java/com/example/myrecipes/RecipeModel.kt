package com.example.myrecipes

import com.example.myrecipes.enums.Meals
import kotlin.properties.Delegates
//нужно делать опциональными, но среда разработки ругается на это
class RecipeModel {
    lateinit var typeOfMeals: Meals
    var title: String? = null
    var countReiting:Float = 0.0f
    var timeToCook by Delegates.notNull<Int>()
    var calories by Delegates.notNull<Int>()
    var beLike:Boolean = false
    var linkImage:String? = null

}