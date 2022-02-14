package com.example.myrecipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.annotation.Nullable
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.myrecipes.databinding.FragmentCustomBottomSheetBinding
import com.example.myrecipes.enums.Dishes
import com.example.myrecipes.enums.Meals
import com.example.myrecipes.ui.search.FilterHolder
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class CustomBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCustomBottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomBottomSheetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val applyBtn = binding.applyBtn
        applyBtn.setOnClickListener {
            this.dismiss()
        }


        val data = FilterHolder()

        val chipGroup: ChipGroup = binding.meals1Cg
        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val mealsChip: Chip = chipGroup.findViewById(checkedId)
            data.selectedMeals =
                when(mealsChip.tag.toString()){
                    "BREAKFAST"-> Meals.BREAKFAST.toString()
                    "BRUNCH"-> Meals.BRUNCH.toString()
                    "DINNER"-> Meals.DINNER.toString()
                    "LUNCH"->Meals.LUNCH.toString()

                    else -> {""}
                }

            setFragmentResult("filterChanged", bundleOf("bundleKey" to data))
        }

        val chipGroupDCG: ChipGroup = binding.dishes1Cg
        chipGroupDCG.setOnCheckedChangeListener { group, checkedId ->
            val dishesChip: Chip =
                chipGroupDCG.findViewById(checkedId)

            data.selectedDish =
                when(dishesChip.tag.toString()){
                    "SOUP"-> Dishes.SOUP.toString()
                    "DESSERT"-> Dishes.DESSERT.toString()
                    "DRINK"-> Dishes.DRINK.toString()
                    "FIRST_COURSE"->Dishes.FIRST_COURSE.toString()
                    "MAIN_COURSE"->Dishes.MAIN_COURSE.toString()
                    "MEAT_DISH"->Dishes.MEAT_DISH.toString()
                    "SNACK"->Dishes.SNACK.toString()

                    else -> {""}
                }

             setFragmentResult("filterChanged", bundleOf("bundleKey" to data))//если оставить тут, то ничего не приезжает
        }

        val countOfMeals = binding.countOfMealsSb
        data.selectedNumberOfServings = countOfMeals.progress


        val timeToCook = binding.timeToCookSb
        data.selectedTimeToCook = timeToCook.progress

        val timeToCookValueTV = binding.timeToCookValueTv

        timeToCook.setOnSeekBarChangeListener(object :OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                timeToCookValueTV.text= progress.toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })


            val calories = binding.caloriesSb
        data.selectedCountOfCalories = calories.progress

        val rating = binding.ratingSb
        data.selectedRating = rating.progress.toFloat()

        return root
    }


    companion object {
        fun newInstance(): CustomBottomSheetFragment {
            return CustomBottomSheetFragment()
        }
    }

}