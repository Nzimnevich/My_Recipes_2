package com.example.myrecipes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myrecipes.databinding.ActivityFullRecipeBinding
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

    private val linearLayoutForSteps by lazy { binding.containerForStepsLl }
    private val linearLayoutForIndigrients by lazy { binding.containerForIndigrientsLl }

    private lateinit var recipeFirst: Recipe

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recipeId = getIntent().getExtras()!!.getInt("ID")
        recipeFirst = setInformRecipe(recipeId)



        typeOfMealsTv.text = getString(getNameForMeals(recipeFirst.meals))
        titleForRecipeTv.text =
            recipeFirst.name //тут тоже вместо локального названия передается захардкоженное
        ratingBarRb.rating = recipeFirst.rating.toFloat()

        timeTV.text = resources.getQuantityString(
            R.plurals.minutes, recipeFirst.timeToCook.toInt(), recipeFirst.timeToCook.toInt()
        )

        countOfCalTv.text = resources.getQuantityString(
            R.plurals.calories, recipeFirst.calories, recipeFirst.calories
        )

        imageIv.setImageResource(
            resources.getIdentifier(
                recipeFirst.imageLink,
                "drawable",
                getPackageName()
            )
        )
        isLikeCB.isChecked = recipeFirst.isLike

        recipeFirst.listIndigrients.forEach {
            var image = ImageView(this)
            image.setImageResource(getPicturesForIngredients(it))

            val marginLayoutParams = ViewGroup.MarginLayoutParams(
                MATCH_PARENT,
                WRAP_CONTENT
            )

            marginLayoutParams.setMargins(
                resources.getDimension(R.dimen.miniMarginFromEdge).toInt(), 0, 0, 0
            )

            image.layoutParams = marginLayoutParams

            linearLayoutForIndigrients.addView(image)
        }

        recipeFirst.listOfSteps.forEach { it ->
            var currentTextView = TextView(this)
            currentTextView.text = it
            val linLayoutParam = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            currentTextView.layoutParams = linLayoutParam
            linearLayoutForSteps.addView(currentTextView)
        }
    }

    fun setInformRecipe(id: Int): Recipe {
        return fakeFoodRepository.sortRecipeById(id)
    }
}