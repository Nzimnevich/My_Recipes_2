package com.example.myrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myrecipes.databinding.ActivityFullRecipeBinding
import com.example.myrecipes.databinding.ActivityWelcomeBinding
import com.example.myrecipes.enums.getNameForMeals
import com.example.myrecipes.enums.getPicturesForIngredients
import kotlin.properties.Delegates

class FullRecipeActivity : AppCompatActivity() {

    private var fakeFoodRepository = FakeFoodRepository()
    private var recipeId by Delegates.notNull<Int>()

    private lateinit var binding: ActivityFullRecipeBinding
    private val typeOfMealsTv by lazy { binding.typeOfMealsTv }
    private val titleForRecipeTv by lazy { binding.titleForRecipeTv }
    private val ratingBarRb by lazy { binding.ratingBarRb }
    private val timeTV by lazy { binding.timeTv }
    private val countOfCalTv by lazy { binding.countOfCalTv }
    private val imageIv by lazy { binding.imageIv }
    private val isLikeCB by lazy { binding.isLikeCb }
    private val ingredient1IV by lazy { binding.ingredient1Iv }
    private val ingredient2IV by lazy { binding.ingredient2Iv }
    private val ingredient3IV by lazy { binding.ingredient3Iv }
    private val ingredient4IV by lazy { binding.ingredient4Iv }
    private val ingredient5IV by lazy { binding.ingredient5Iv }
    private val firstStepTv by lazy { binding.step1Tv }
    private val secondStepTv by lazy { binding.step2Tv }

    private lateinit var recipeFirst: Recipe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recipeId = getIntent().getExtras()!!.getInt("ID")
        recipeFirst = setInformRecipe(recipeId)



        typeOfMealsTv.setText(getString(getNameForMeals(recipeFirst.meals)) )
        titleForRecipeTv.setText(recipeFirst.name) //тут тоже вместо локального названия передается захардкоженное
        ratingBarRb.rating = recipeFirst.rating.toFloat()
        timeTV.setText(recipeFirst.timeToCook.toString() + getString(R.string.minutes)) //тут захардкоженные значения, как-то можно вместо этого plurals?
        countOfCalTv.setText(recipeFirst.calories.toString() +getString(R.string.calories)) //тут захардкоженные значения, как-то можно вместо этого plurals?
        imageIv.setImageResource(
            resources.getIdentifier(
                recipeFirst.imageLink,
                "drawable",
                getPackageName()
            )
        )
        isLikeCB.isChecked = recipeFirst.isLike

        ingredient1IV.setImageResource(getPicturesForIngredients(recipeFirst.listIndigrients.get(0)))
        ingredient2IV.setImageResource(getPicturesForIngredients(recipeFirst.listIndigrients.get(1)))
        ingredient3IV.setImageResource(getPicturesForIngredients(recipeFirst.listIndigrients.get(2)))
        ingredient4IV.setImageResource(getPicturesForIngredients(recipeFirst.listIndigrients.get(3)))
        ingredient5IV.setImageResource(getPicturesForIngredients(recipeFirst.listIndigrients.get(4)))

        firstStepTv.setText(recipeFirst.listOfSteps.get(0))//тут захардкоженные шаги
        secondStepTv.setText(recipeFirst.listOfSteps.get(1)) //тут захардкоженные шаги


    }

    fun setInformRecipe(id: Int): Recipe {
        return fakeFoodRepository.sortRecipeById(id)
    }
}